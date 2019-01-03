package com.example.chin.domain.add

import com.example.chin.data.dao.ShoppingDataSource
import com.example.chin.data.entities.ShoppingLocalEntity
import com.example.chin.domain.entities.ShoppingItem
import kotlinx.coroutines.Job
import javax.inject.Inject

class AddItemUseCaseImpl @Inject constructor(
    override val job: Job,
    private val shoppingDataSource: ShoppingDataSource
) : AddItemUseCase {

    override suspend fun run(input: ShoppingItem) {

        shoppingDataSource.obtainDao().insertAll(
            ShoppingLocalEntity(input.name, input.quantity)
        )

    }

}