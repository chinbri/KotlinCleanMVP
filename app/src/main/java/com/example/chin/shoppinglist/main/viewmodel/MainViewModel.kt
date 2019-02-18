package com.example.chin.shoppinglist.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chin.domain.*
import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.navigator.Navigator

class MainViewModel: ViewModel() {

    private lateinit var navigator: Navigator
    private lateinit var obtainListUseCase: ObtainListUseCase
    private lateinit var addItemOrUpdateUseCase: AddItemOrUpdateUseCase
    private lateinit var deleteItemUseCase: DeleteItemUseCase

    fun initialize(navigator: Navigator,
                   obtainListUseCase: ObtainListUseCase,
                   addItemOrUpdateUseCase: AddItemOrUpdateUseCase,
                   deleteItemUseCase: DeleteItemUseCase){
        this.navigator = navigator
        this.obtainListUseCase = obtainListUseCase
        this.addItemOrUpdateUseCase = addItemOrUpdateUseCase
        this.deleteItemUseCase = deleteItemUseCase
    }

    var eventNotification: MutableLiveData<Event<UseCaseNotification>?> = MutableLiveData()
    var listItems: MutableLiveData<List<ShoppingItem>> = MutableLiveData()

    fun obtainList() {
        obtainListUseCase.executeAsync(Unit) {
            eventNotification.value = it.event
            listItems.value = it.output ?: emptyList()
        }
    }

    fun addItem() {
        navigator.displayAddItemDialog(
            { shoppingItem ->
                addItemOrUpdateUseCase.executeAsync(shoppingItem){ it ->

                    eventNotification.value = it.event

                    if(!it.existEventNotification()){
                        obtainList()
                    }
                }
            }
        )
    }

    fun onItemSelected(item: ShoppingItem) {
        navigator.displayAddItemDialog(
            { shoppingItem ->
                addItemOrUpdateUseCase.executeAsync(shoppingItem){

                    eventNotification.value = it.event

                    if(!it.existEventNotification()){
                        obtainList()
                    }
                }
            },
            item
        )
    }

    fun onItemDeleted(item: ShoppingItem) {
        deleteItemUseCase.executeAsync(item){
            eventNotification.value = it.event
            listItems.value = it.output ?: emptyList()
        }
    }

}