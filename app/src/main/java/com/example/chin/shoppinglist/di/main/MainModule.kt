package com.example.chin.shoppinglist.di.main

import androidx.lifecycle.ViewModelProviders
import com.example.chin.data.gateways.MainLocalGateway
import com.example.chin.data.gateways.MainLocalGatewayImpl
import com.example.chin.domain.AddItemOrUpdateUseCase
import com.example.chin.domain.DeleteItemUseCase
import com.example.chin.domain.ObtainListUseCase
import com.example.chin.domain.main.add.AddItemOrUpdateUseCaseImpl
import com.example.chin.domain.main.delete.DeleteItemUseCaseImpl
import com.example.chin.domain.main.ObtainListUseCaseImpl
import com.example.chin.navigator.Navigator
import com.example.chin.shoppinglist.BaseActivity
import com.example.chin.shoppinglist.main.viewmodel.MainViewModel
import com.example.chin.shoppinglist.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @MainScope
    fun providesMainViewModel(
        activity: BaseActivity,
        navigator: Navigator,
        obtainListUseCase: ObtainListUseCase,
        addItemOrUpdateUseCase: AddItemOrUpdateUseCase,
        deleteItemUseCase: DeleteItemUseCase
    ): MainViewModel = ViewModelProviders
        .of(activity, MainViewModelFactory(navigator, obtainListUseCase, addItemOrUpdateUseCase, deleteItemUseCase))
        .get(MainViewModel::class.java)

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