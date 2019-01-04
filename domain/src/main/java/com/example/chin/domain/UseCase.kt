package com.example.chin.domain

import kotlinx.coroutines.*

interface UseCase<InputType, OutputType> {

    val job: Job
    fun obtainUiScope() = CoroutineScope(Dispatchers.Main + job)
    fun obtainIoScope() = CoroutineScope(Dispatchers.Default + job)

    fun executeAsync(param: InputType, callback: (OutputType) -> Unit){

        obtainIoScope().async {
            val output = run(param);
            obtainUiScope().launch {
                callback.invoke(output)
            }
        }

    }

    /**
     * this method has to be executed inside a coroutine.
     * i.e.:
     * CoroutineScope(Dispatchers.Main + job).launch { usecase.executeSync("whatever") }
     * @see CoroutineScope
     */
    suspend fun executeSync(param: InputType) = withContext(Dispatchers.Default){
        run(param)
    }

    suspend fun run(input: InputType):OutputType

}