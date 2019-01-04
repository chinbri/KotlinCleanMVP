package com.example.chin.data.gateways

import com.example.chin.data.entities.ShoppingLocalEntity

interface MainLocalGateway {

    suspend fun getShoppingItems(): List<ShoppingLocalEntity>

    suspend fun insertOrUpdate(input: ShoppingLocalEntity)

    suspend fun deleteItem(item: ShoppingLocalEntity)
}