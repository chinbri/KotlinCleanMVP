package com.example.chin.data.gateways

import com.example.chin.data.entities.ShoppingLocalEntity
import javax.inject.Inject

class MainLocalGatewayImpl @Inject constructor(): MainLocalGateway {

    override fun getShoppingItems(): List<ShoppingLocalEntity> {
        return listOf(
            ShoppingLocalEntity("aaa", 2),
            ShoppingLocalEntity("bbb",43)
        )
    }

}