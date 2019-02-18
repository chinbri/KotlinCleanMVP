package com.example.chin.domain

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

interface UseCase<InputType, OutputType> {

    val job: Job
    fun obtainUiScope() = CoroutineScope(Dispatchers.Main + job)
    fun obtainIoScope() = CoroutineScope(Dispatchers.Default + job)

    fun executeAsync(param: InputType, callback: (UseCaseResponse<OutputType>) -> Unit){

        obtainIoScope().launch {
            val output = run(param)
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
    suspend fun executeSync(param: InputType, coroutineContext: CoroutineContext = Dispatchers.Default + job) = withContext(coroutineContext){
        run(param)
    }

    suspend fun run(input: InputType):UseCaseResponse<OutputType>

}

class UseCaseResponse<OutputType>(val event: Event<UseCaseNotification>? = null, val output:OutputType? = null){

    fun existEventNotification() = event != null

}