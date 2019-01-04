package com.example.chin.shoppinglist.di.main

import com.example.chin.data.gateways.MainLocalGateway
import com.example.chin.data.gateways.MainLocalGatewayImpl
import com.example.chin.domain.AddItemOrUpdateUseCase
import com.example.chin.domain.DeleteItemUseCase
import com.example.chin.domain.ObtainListUseCase
import com.example.chin.domain.main.add.AddItemOrUpdateUseCaseImpl
import com.example.chin.domain.main.delete.DeleteItemUseCaseImpl
import com.example.chin.domain.main.ObtainListUseCaseImpl
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
    fun providesMainUseCase(impl: ObtainListUseCaseImpl): ObtainListUseCase = impl

    @Provides
    @MainScope
    fun providesMainLocalGateway(impl: MainLocalGatewayImpl): MainLocalGateway = impl

    @Provides
    @MainScope
    fun providesAddItemUseCase(impl: AddItemOrUpdateUseCaseImpl): AddItemOrUpdateUseCase = impl

    @Provides
    @MainScope
    fun providesDeleteItemUseCase(impl: DeleteItemUseCaseImpl): DeleteItemUseCase = impl
}