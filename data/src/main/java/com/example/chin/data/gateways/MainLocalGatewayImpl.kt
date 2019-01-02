package com.example.chin.data.gateways

import com.example.chin.data.dao.ShoppingDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainLocalGatewayImpl @Inject constructor(
    private val shoppingDataSource: ShoppingDataSource
): MainLocalGateway {

    override suspend fun getShoppingItems() = shoppingDataSource.obtainDao().getAll()

}