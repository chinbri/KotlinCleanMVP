package com.example.chin.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseUseCase<InputType, OutputType>(job: Job = Job()): UseCase<InputType, OutputType> {

    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun executeAsync(param: InputType, callback: (OutputType) -> Unit){

        uiScope.launch {

            callback.invoke(run(param))

        }

    }

    override suspend fun executeSync(param: InputType): OutputType{
        return run(param)
    }

    protected abstract suspend fun run(input: InputType):OutputType

}