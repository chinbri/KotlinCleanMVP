package com.example.chin.shoppinglist

import android.app.Application
import com.example.chin.shoppinglist.di.ApplicationComponent
import com.example.chin.shoppinglist.di.ApplicationModule
import com.example.chin.shoppinglist.di.DaggerApplicationComponent

class ShoppingApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)

    }

}