package com.example.chin.shoppinglist.navigator

import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.presentation.navigator.Navigator
import com.example.chin.shoppinglist.ui.BaseActivity
import com.example.chin.shoppinglist.ui.main.AddItemDialogFragment
import javax.inject.Inject

class NavigatorImpl @Inject constructor(private val activity: BaseActivity): Navigator {

    override fun displayAddItemDialog(shoppingItem: ShoppingItem?) {
        AddItemDialogFragment.getInstance(shoppingItem)
            .show(activity.supportFragmentManager, AddItemDialogFragment.TAG)
    }

}