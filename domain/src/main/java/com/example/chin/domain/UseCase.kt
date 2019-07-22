package com.example.chin.domain

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

interface UseCase<InputType, OutputType> {

    fun executeAsync(param: InputType, job: Job, callback: (UseCaseResponse<OutputType>) -> Unit){

        CoroutineScope(Dispatchers.IO + job).launch {
            val output = run(job, param)
            CoroutineScope(Dispatchers.Main + job).launch {
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
    suspend fun executeSync(param: InputType, job: Job, coroutineContext: CoroutineContext = Dispatchers.Default + job) = withContext(coroutineContext){
        run(job, param)
    }

    suspend fun run(job: Job, input: InputType):UseCaseResponse<OutputType>

}

class UseCaseResponse<OutputType>(val event: Event<UseCaseNotification>? = null, val output:OutputType? = null){

    fun existEventNotification() = event != null

}