package com.example.chin.shoppinglist.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.chin.domain.AddItemListener
import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.shoppinglist.R
import com.example.chin.shoppinglist.di.main.AddItemModule
import com.example.chin.shoppinglist.ui.BaseActivity
import com.example.chin.shoppinglist.ui.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_add_item.*

class AddItemDialogFragment: BaseDialogFragment() {

    private lateinit var currentItem: ShoppingItem

    private lateinit var listener: AddItemListener

    companion object {

        val TAG: String? = AddItemDialogFragment::class.java.simpleName

        fun getInstance(currentItem: ShoppingItem?, listener: AddItemListener): AddItemDialogFragment{
            val fragment = AddItemDialogFragment()
            fragment.currentItem = currentItem ?: ShoppingItem(0,"", 0)
            fragment.listener = listener
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        etItemName.setText(currentItem.name)
        etItemName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(value: Editable?) {

                currentItem.name = value?.toString() ?: ""
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        etQuantity.setText(currentItem.quantity.toString())
        etQuantity.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(value: Editable?) {

                try{
                    currentItem.quantity = value?.toString()?.toInt() ?: 0
                }catch (e: NumberFormatException){
                    currentItem.quantity = 0
                }


            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        btAccept.setOnClickListener {
            listener.invoke(currentItem)
            dismiss()
        }
        btCancel.setOnClickListener {
            dismiss()
        }
    }
}