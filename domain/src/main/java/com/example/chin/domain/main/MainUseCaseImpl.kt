package com.example.chin.domain.main

import com.example.chin.data.gateways.MainLocalGateway
import com.example.chin.domain.BaseUseCase
import com.example.chin.domain.entities.ShoppingItem
import kotlinx.coroutines.Job
import javax.inject.Inject

class MainUseCaseImpl @Inject constructor(job: Job, val mainLocalGateway: MainLocalGateway): BaseUseCase<String, List<ShoppingItem>>(job), MainUseCase {

    override suspend fun run(input: String): List<ShoppingItem> {

        return mainLocalGateway.getShoppingItems().map {
            ShoppingItem(
                it.name,
                it.quantity
            )
        }

    }

}