package com.example.chin.presentation.main

import com.example.chin.domain.entities.ShoppingItem

interface MainView {

    fun showMessage(message: String)

    fun drawList(items: List<ShoppingItem>)

}