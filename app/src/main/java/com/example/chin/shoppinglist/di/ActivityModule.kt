package com.example.chin.shoppinglist.di

import android.content.Context
import androidx.room.Room
import com.example.chin.data.dao.ShoppingDao
import com.example.chin.data.dao.ShoppingDataSource
import com.example.chin.data.dao.ShoppingDataSourceImpl
import com.example.chin.presentation.navigator.Navigator
import com.example.chin.shoppinglist.database.AppDatabase
import com.example.chin.shoppinglist.navigator.NavigatorImpl
import com.example.chin.shoppinglist.ui.BaseActivity
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Job

@Module
class ActivityModule(private val activity: BaseActivity) {

    private val shoppingDao by lazy {
        Room.databaseBuilder(
            activity,
            AppDatabase::class.java, "my_database"
        ).build().shoppingDao()
    }

    @Provides
    @ActivityScope
    fun providesContext(): Context {
        return activity
    }

    @Provides
    @ActivityScope
    fun providesActivity(): BaseActivity {
        return activity
    }

    @Provides
    @ActivityScope
    fun providesActivityJob(): Job {
        return activity.job
    }

    @Provides
    @ActivityScope
    fun providesNavigator(impl: NavigatorImpl): Navigator = impl

    @Provides
    @ActivityScope
    fun providesShoppingDataSource(impl: ShoppingDataSourceImpl): ShoppingDataSource = impl

    @Provides
    @ActivityScope
    fun providesShoppingDao() = shoppingDao

}