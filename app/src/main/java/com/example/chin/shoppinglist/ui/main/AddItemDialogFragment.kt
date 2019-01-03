package com.example.chin.shoppinglist.ui.main

import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.shoppinglist.R
import com.example.chin.shoppinglist.di.main.AddItemModule
import com.example.chin.shoppinglist.ui.BaseActivity
import com.example.chin.shoppinglist.ui.BaseDialogFragment

class AddItemDialogFragment: BaseDialogFragment() {

    private var currentItem: ShoppingItem? = null

    companion object {

        val TAG: String? = AddItemDialogFragment::class.java.simpleName

        fun getInstance(currentItem: ShoppingItem?): AddItemDialogFragment{
            val fragment = AddItemDialogFragment()
            fragment.currentItem = currentItem
            return fragment
        }

    }

    override fun injectComponent() {
        (activity as BaseActivity)
            .activityComponent
            .addItemComponentBuilder()
            .addItemModule(AddItemModule())
            .build()
            .inject(this)
    }

    override fun getLayoutResource() = R.layout.dialog_add_item

}