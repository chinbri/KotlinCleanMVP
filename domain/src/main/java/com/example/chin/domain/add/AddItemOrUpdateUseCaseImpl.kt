package com.example.chin.domain.add

import com.example.chin.data.dao.ShoppingDataSource
import com.example.chin.data.entities.ShoppingLocalEntity
import com.example.chin.data.gateways.MainLocalGateway
import com.example.chin.domain.entities.ShoppingItem
import kotlinx.coroutines.Job
import javax.inject.Inject

class AddItemOrUpdateUseCaseImpl @Inject constructor(
    override val job: Job,
    private val mainLocalGateway: MainLocalGateway
) : AddItemOrUpdateUseCase {

    override suspend fun run(input: ShoppingItem) =
        mainLocalGateway.insertOrUpdate(ShoppingLocalEntity(input.name, input.quantity))

}