package com.example.chin.shoppinglist.di

import com.example.chin.shoppinglist.di.main.MainSubComponent
import dagger.Component


@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface ActivityComponent {

    fun mainComponentBuilder(): MainSubComponent.Builder

}