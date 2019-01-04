package com.example.chin.shoppinglist.ui.main

import android.os.Bundle
import android.widget.Toast
import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.presentation.main.MainPresenter
import com.example.chin.presentation.main.MainView
import com.example.chin.shoppinglist.R
import com.example.chin.shoppinglist.di.main.AddItemModule
import com.example.chin.shoppinglist.di.main.MainModule
import com.example.chin.shoppinglist.ui.BaseActivity
import com.example.chin.shoppinglist.ui.main.adapter.ShoppingListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    val adapter = ShoppingListAdapter(
        listener = { presenter.onItemSelected(it) },
        deleteListener = { presenter.onItemDeleted(it) }
    )

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent
            .mainComponentBuilder()
            .mainModule(MainModule()).build()
            .inject(this)

        setupView()

        presenter.initialize(this)

    }

    private fun setupView() {

        rvShoppingList.adapter = adapter

        btnAddItem.setOnClickListener{
            presenter.addItem()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun drawList(items: List<ShoppingItem>) {

        adapter.shoppingItems = items
        adapter.notifyDataSetChanged()

    }


}
