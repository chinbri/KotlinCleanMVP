package com.example.chin.shoppinglist.di

import com.example.chin.shoppinglist.ShoppingApplication
import dagger.Component


@Component(modules = [ ApplicationModule::class ] )
interface ApplicationComponent{

    fun inject(application: ShoppingApplication)

}