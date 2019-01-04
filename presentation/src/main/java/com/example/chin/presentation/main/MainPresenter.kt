package com.example.chin.presentation.main

import com.example.chin.domain.entities.ShoppingItem

interface MainPresenter {

    fun addItem()

    fun initialize(view: MainView)

    fun onItemSelected(item: ShoppingItem)

    fun onItemDeleted(item: ShoppingItem)

}