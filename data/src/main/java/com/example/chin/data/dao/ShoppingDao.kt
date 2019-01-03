package com.example.chin.data.dao

import androidx.room.*
import com.example.chin.data.entities.ShoppingLocalEntity


@Dao
interface ShoppingDao {

    @Query("SELECT * FROM shoppingItem")
    fun getAll(): List<ShoppingLocalEntity>

    @Query("SELECT * FROM shoppingItem WHERE name IN (:userNames)")
    fun loadAllByIds(vararg userNames: String): List<ShoppingLocalEntity>

    @Query("SELECT * FROM shoppingItem WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): ShoppingLocalEntity?

    @Insert
    fun insertAll(vararg users: ShoppingLocalEntity)

    @Delete
    fun delete(item: ShoppingLocalEntity)

    @Update
    fun update(item: ShoppingLocalEntity)

}