package com.example.chin.data.gateways

import com.example.chin.data.entities.ShoppingLocalEntity
import com.example.chin.data.exceptions.ItemDuplicatedException

interface MainLocalGateway {

    suspend fun getShoppingItems(): List<ShoppingLocalEntity>

    @Throws(ItemDuplicatedException::class)
    suspend fun insertOrUpdate(input: ShoppingLocalEntity)

    suspend fun deleteItem(item: ShoppingLocalEntity)
}