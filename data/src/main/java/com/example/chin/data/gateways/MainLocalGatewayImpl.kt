package com.example.chin.data.gateways

import com.example.chin.data.dao.ShoppingDataSource
import com.example.chin.data.entities.ShoppingLocalEntity
import com.example.chin.data.exceptions.ItemDuplicatedException
import javax.inject.Inject

class MainLocalGatewayImpl @Inject constructor(
    shoppingDataSource: ShoppingDataSource
): MainLocalGateway {

    private val shoppingDao = shoppingDataSource.obtainDao()

    override suspend fun getShoppingItems() = shoppingDao.getAll()

    @Throws(ItemDuplicatedException::class)
    override suspend fun insertOrUpdate(input: ShoppingLocalEntity) {
        val localEntity: ShoppingLocalEntity?
        if(input.id != 0){

            localEntity = shoppingDao.findById(input.id)

            if(localEntity != null){
                localEntity.name = input.name
                localEntity.quantity = input.quantity
                shoppingDao.update(localEntity)
            }else{
                //this should't happen!!
            }

        }else{
            if(shoppingDao.findByName(input.name) != null){
                throw ItemDuplicatedException()
            }else{
                shoppingDao.insertAll(input)
            }
        }

    }

    override suspend fun deleteItem(item: ShoppingLocalEntity) = shoppingDao.delete(item)

}