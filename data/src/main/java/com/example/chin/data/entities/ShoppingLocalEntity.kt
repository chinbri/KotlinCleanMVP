package com.example.chin.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chin.data.dao.ShoppingDao

@Entity(tableName = ShoppingDao.TABLE_NAME)
data class ShoppingLocalEntity (
    @PrimaryKey
    @ColumnInfo(name = ShoppingDao.COLUMN_NAME)
    val name: String,

    @ColumnInfo(name = ShoppingDao.COLUMN_QUANTITY)
    val quantity: Int
)