package com.example.chin.shoppinglist.di.main

import com.example.chin.domain.main.MainUseCase
import com.example.chin.domain.main.MainUseCaseImpl
import com.example.chin.presentation.main.MainPresenter
import com.example.chin.presentation.main.MainPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @MainScope
    fun providesMainPresenter(impl: MainPresenterImpl):MainPresenter = impl

    @Provides
    @MainScope
    fun providesMainUseCase(impl: MainUseCaseImpl): MainUseCase = impl

}