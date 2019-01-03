package com.example.chin.presentation.navigator

import com.example.chin.domain.entities.ShoppingItem

interface Navigator {

    fun displayAddItemDialog(shoppingItem: ShoppingItem? = null)

}