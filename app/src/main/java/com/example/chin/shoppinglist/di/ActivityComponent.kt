package com.example.chin.shoppinglist.di

import com.example.chin.navigator.Navigator
import com.example.chin.shoppinglist.BaseActivity
import com.example.chin.shoppinglist.di.main.AddItemSubComponent
import com.example.chin.shoppinglist.di.main.MainSubComponent
import dagger.Component
import kotlinx.coroutines.Job


@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface ActivityComponent {

    fun mainComponentBuilder(): MainSubComponent.Builder

    fun addItemComponentBuilder(): AddItemSubComponent.Builder

    fun providesActivity(): BaseActivity

    fun providesJob(): Job

    fun providesNavigator(): Navigator

}