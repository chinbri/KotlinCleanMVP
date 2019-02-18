package com.example.chin.domain.main.add

import com.example.chin.data.entities.ShoppingLocalEntity
import com.example.chin.data.exceptions.ItemDuplicatedException
import com.example.chin.data.gateways.MainLocalGateway
import com.example.chin.domain.AddItemOrUpdateUseCase
import com.example.chin.domain.Event
import com.example.chin.domain.ItemDuplicatedNotification
import com.example.chin.domain.UseCaseResponse
import com.example.chin.domain.entities.ShoppingItem
import kotlinx.coroutines.Job
import javax.inject.Inject

class AddItemOrUpdateUseCaseImpl @Inject constructor(
    override val job: Job,
    private val mainLocalGateway: MainLocalGateway
) : AddItemOrUpdateUseCase {

    override suspend fun run(input: ShoppingItem): UseCaseResponse<Unit> {
        try{

            mainLocalGateway.insertOrUpdate(ShoppingLocalEntity(input.name, input.quantity, input.id))

        }catch (e: ItemDuplicatedException){
            return UseCaseResponse(Event(ItemDuplicatedNotification()))
        }

        return UseCaseResponse()

    }

}