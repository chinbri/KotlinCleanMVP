package com.example.chin.domain.main

import com.example.chin.data.gateways.MainLocalGateway
import com.example.chin.domain.entities.ShoppingItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import javax.inject.Inject

class ObtainListUseCaseImpl @Inject constructor(
    override val job: Job,
    private val mainLocalGateway: MainLocalGateway
): ObtainListUseCase {

    override suspend fun run(input: String): List<ShoppingItem> {

        return mainLocalGateway.getShoppingItems().map {
            ShoppingItem(
                it.name,
                it.quantity
            )
        }

    }

}