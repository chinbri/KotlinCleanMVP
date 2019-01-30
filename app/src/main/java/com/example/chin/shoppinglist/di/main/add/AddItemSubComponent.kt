package com.example.chin.shoppinglist.di.main

import com.example.chin.shoppinglist.main.ui.AddItemDialogFragment
import dagger.Subcomponent

@Subcomponent(modules = [ AddItemModule::class ])
@AddItemScope
interface AddItemSubComponent {

    fun inject(fragment: AddItemDialogFragment)

    @Subcomponent.Builder
    interface Builder {

        fun  addItemModule(module: AddItemModule): Builder

        fun build(): AddItemSubComponent

    }

}