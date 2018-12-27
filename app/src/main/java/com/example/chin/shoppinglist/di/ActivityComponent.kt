package com.example.chin.shoppinglist.di

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

    fun providesJob(): Job


}