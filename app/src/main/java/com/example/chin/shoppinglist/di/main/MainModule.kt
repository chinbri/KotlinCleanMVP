package com.example.chin.shoppinglist.di.main

import com.example.chin.presentation.main.MainPresenter
import com.example.chin.presentation.main.MainPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providesMainPresenter(impl: MainPresenterImpl):MainPresenter = impl

}