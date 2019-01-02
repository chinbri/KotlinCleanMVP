package com.example.chin.domain

import kotlinx.coroutines.*

abstract class BaseUseCase<InputType, OutputType>(job: Job = Job()): UseCase<InputType, OutputType> {

    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    private val ioScope = CoroutineScope(Dispatchers.IO + job)

    override fun executeAsync(param: InputType, callback: (OutputType) -> Unit){

        ioScope.async {
            val output = run(param);
            uiScope.launch {
                callback.invoke(output)
            }
        }

    }

    override suspend fun executeSync(param: InputType) = withContext(Dispatchers.IO){
        run(param)
    }

    protected abstract suspend fun run(input: InputType):OutputType

}