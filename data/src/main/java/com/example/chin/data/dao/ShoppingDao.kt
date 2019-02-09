package com.example.chin.data.dao

import androidx.room.*
import com.example.chin.data.entities.ShoppingLocalEntity


@Dao
interface ShoppingDao {

    companion object {
        const val TABLE_NAME = "shoppingItem"

        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_QUANTITY = "quantity"
    }

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getAll(): List<ShoppingLocalEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_NAME IN (:userNames)")
    suspend fun loadAllByIds(vararg userNames: String): List<ShoppingLocalEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_NAME LIKE :name LIMIT 1")
    suspend fun findByName(name: String): ShoppingLocalEntity?

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID LIKE :id LIMIT 1")
    suspend fun findById(id: Int): ShoppingLocalEntity?

    @Insert
    suspend fun insertAll(vararg users: ShoppingLocalEntity)

    @Delete
    suspend fun delete(item: ShoppingLocalEntity)

    @Update
    suspend fun update(item: ShoppingLocalEntity)

}