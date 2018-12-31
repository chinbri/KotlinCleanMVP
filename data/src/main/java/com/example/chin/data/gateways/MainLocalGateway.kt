package com.example.chin.data.gateways

import com.example.chin.data.entities.ShoppingLocalEntity

interface MainLocalGateway {

    suspend fun getShoppingItems(): List<ShoppingLocalEntity>

}