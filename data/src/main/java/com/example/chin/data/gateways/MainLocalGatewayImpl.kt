package com.example.chin.data.gateways

import com.example.chin.data.dao.ShoppingDataSource
import com.example.chin.data.entities.ShoppingLocalEntity
import javax.inject.Inject

class MainLocalGatewayImpl @Inject constructor(
    shoppingDataSource: ShoppingDataSource
): MainLocalGateway {

    private val shoppingDao = shoppingDataSource.obtainDao()

    override suspend fun getShoppingItems() = shoppingDao.getAll()

    override suspend fun insertOrUpdate(input: ShoppingLocalEntity) {
        if(shoppingDao.findByName(input.name) != null){
            shoppingDao.update(
                ShoppingLocalEntity(input.name, input.quantity)
            )
        }else{
            shoppingDao.insertAll(
                ShoppingLocalEntity(input.name, input.quantity)
            )
        }
    }

}