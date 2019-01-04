package com.example.chin.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chin.data.dao.ShoppingDao

@Entity(tableName = ShoppingDao.TABLE_NAME)
data class ShoppingLocalEntity (

    @ColumnInfo(name = ShoppingDao.COLUMN_NAME)
    var name: String,

    @ColumnInfo(name = ShoppingDao.COLUMN_QUANTITY)
    var quantity: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ShoppingDao.COLUMN_ID)
    val id: Int = 0
)