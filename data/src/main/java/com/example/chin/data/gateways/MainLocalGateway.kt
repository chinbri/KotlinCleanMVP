package com.example.chin.data.gateways

import com.example.chin.data.entities.ShoppingLocalEntity

interface MainLocalGateway {

    fun getShoppingItems(): List<ShoppingLocalEntity>

}