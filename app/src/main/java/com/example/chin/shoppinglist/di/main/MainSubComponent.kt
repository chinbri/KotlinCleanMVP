package com.example.chin.shoppinglist.di.main

import com.example.chin.shoppinglist.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [ MainModule::class ])
@MainScope
interface MainSubComponent {

    fun inject(homeActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {

        fun  mainModule(homeModule: MainModule): Builder

        fun build(): MainSubComponent

    }

}