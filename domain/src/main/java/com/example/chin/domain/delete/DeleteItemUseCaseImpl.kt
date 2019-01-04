package com.example.chin.domain.delete

import com.example.chin.data.entities.ShoppingLocalEntity
import com.example.chin.data.gateways.MainLocalGateway
import com.example.chin.domain.DeleteItemUseCase
import com.example.chin.domain.entities.ShoppingItem
import kotlinx.coroutines.Job
import javax.inject.Inject

class DeleteItemUseCaseImpl @Inject constructor(
    override val job: Job,
    private val mainLocalGateway: MainLocalGateway
) : DeleteItemUseCase {

    override suspend fun run(input: ShoppingItem): List<ShoppingItem> {

        mainLocalGateway.deleteItem(ShoppingLocalEntity(input.name, input.quantity, input.id))

        return mainLocalGateway.getShoppingItems().map {
            ShoppingItem(it.id, it.name, it.quantity)
        }

    }

}