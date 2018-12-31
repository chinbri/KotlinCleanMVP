package com.example.chin.shoppinglist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chin.data.dao.ShoppingDao
import com.example.chin.data.entities.ShoppingLocalEntity

@Database(entities = [ShoppingLocalEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase()  {
    abstract fun shoppingDao(): ShoppingDao
}