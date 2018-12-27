package com.example.chin.domain

interface UseCase<T, K> {

    fun executeAsync(param: T, callback: (K) -> Unit)

    suspend fun executeSync(param: T): K

}