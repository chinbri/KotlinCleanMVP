package com.example.chin.domain.main

import com.example.chin.domain.BaseUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import javax.inject.Inject

class MainUseCaseImpl @Inject constructor(job: Job): BaseUseCase<String, String>(job), MainUseCase {

    override suspend fun run(input: String): String {

        delay(5000)
        return "use case called"

    }

}