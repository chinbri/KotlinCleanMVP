package com.example.chin.data.dao

import javax.inject.Inject

interface ShoppingDataSource{
    fun obtainDao(): ShoppingDao
}

class ShoppingDataSourceImpl @Inject constructor(val shoppingDao: ShoppingDao):ShoppingDataSource {
    override fun obtainDao() = shoppingDao
}