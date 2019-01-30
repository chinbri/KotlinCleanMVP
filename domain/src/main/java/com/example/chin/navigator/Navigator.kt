package com.example.chin.navigator

import com.example.chin.domain.AddItemListener
import com.example.chin.domain.entities.ShoppingItem

interface Navigator {

    fun displayAddItemDialog(listener: AddItemListener, currentItem: ShoppingItem? = null)

}