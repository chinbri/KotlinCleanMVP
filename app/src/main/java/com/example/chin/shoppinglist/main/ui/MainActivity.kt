package com.example.chin.shoppinglist.main.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.chin.domain.ItemDuplicatedNotification
import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.navigator.Navigator
import com.example.chin.shoppinglist.R
import com.example.chin.shoppinglist.di.main.MainModule
import com.example.chin.shoppinglist.BaseActivity
import com.example.chin.shoppinglist.main.ui.adapter.ShoppingListAdapter
import com.example.chin.shoppinglist.main.viewmodel.MainViewModel
import com.example.chin.shoppinglist.main.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    @Inject
    lateinit var navigator: Navigator

    lateinit var mainViewModel: MainViewModel

    val adapter = ShoppingListAdapter(
        listener = {
            navigator.displayAddItemDialog(
                { shoppingItem ->
                    mainViewModel.onItemSelected(shoppingItem)
                }, it)
        },
        deleteListener = { mainViewModel.onItemDeleted(it) }
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent
            .mainComponentBuilder()
            .mainModule(MainModule()).build()
            .inject(this)

        setupViewModels()

        setupView()

    }

    private fun setupViewModels() {

        mainViewModel = mainViewModelFactory.create(MainViewModel::class.java)

        mainViewModel.viewJob = job

        mainViewModel.listItems.observe(this,
            Observer {
                drawList(it)
            })

        mainViewModel.eventNotification.observe(this,
            Observer{
                if(it?.getContentIfNotHandled() is ItemDuplicatedNotification){
                    showMessage(resources.getString(R.string.error))
                }
            })

    }

    private fun setupView() {

        rvShoppingList.adapter = adapter

        btnAddItem.setOnClickListener{
            navigator.displayAddItemDialog(
                { shoppingItem ->
                    mainViewModel.addItem(shoppingItem)
                }
            )
        }

        mainViewModel.obtainList()
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun drawList(items: List<ShoppingItem>) {

        adapter.shoppingItems = items
        adapter.notifyDataSetChanged()

    }


}
