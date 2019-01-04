package com.example.chin.domain.main

import com.example.chin.data.gateways.MainLocalGateway
import com.example.chin.domain.ObtainListUseCase
import com.example.chin.domain.UseCaseResponse
import com.example.chin.domain.entities.ShoppingItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import javax.inject.Inject

class ObtainListUseCaseImpl @Inject constructor(
    override val job: Job,
    private val mainLocalGateway: MainLocalGateway
): ObtainListUseCase {

    override suspend fun run(input: Unit): UseCaseResponse<List<ShoppingItem>>{

        return UseCaseResponse(
            output = mainLocalGateway.getShoppingItems().map {
                ShoppingItem(
                    it.id,
                    it.name,
                    it.quantity
                )
            }
        )

    }

}