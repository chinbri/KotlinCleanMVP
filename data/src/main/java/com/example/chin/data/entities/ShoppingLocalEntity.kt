package com.example.chin.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoppingItem")
data class ShoppingLocalEntity (
    @PrimaryKey val name: String,
    val quantity: Int
)