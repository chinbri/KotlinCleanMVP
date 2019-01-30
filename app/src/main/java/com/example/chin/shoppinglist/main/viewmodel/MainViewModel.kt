package com.example.chin.shoppinglist.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chin.domain.AddItemOrUpdateUseCase
import com.example.chin.domain.DeleteItemUseCase
import com.example.chin.domain.ObtainListUseCase
import com.example.chin.domain.UseCaseNotification
import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.navigator.Navigator

class MainViewModel constructor(
    private val navigator: Navigator,
    private val obtainListUseCase: ObtainListUseCase,
    private val addItemOrUpdateUseCase: AddItemOrUpdateUseCase,
    private val deleteItemUseCase: DeleteItemUseCase
) : ViewModel() {

    var notification: MutableLiveData<UseCaseNotification?> = MutableLiveData()
    var listItems: MutableLiveData<List<ShoppingItem>> = MutableLiveData()

    fun obtainList() {
        obtainListUseCase.executeAsync(Unit) {
            notification.value = it.notification
            listItems.value = it.output ?: emptyList()
        }
    }

    fun addItem() {
        navigator.displayAddItemDialog(
            { shoppingItem ->
                addItemOrUpdateUseCase.executeAsync(shoppingItem){ it ->

                    notification.value = it.notification

                    if(!it.existNotification()){
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

                    notification.value = it.notification

                    if(!it.existNotification()){
                        obtainList()
                    }
                }
            },
            item
        )
    }

    fun onItemDeleted(item: ShoppingItem) {
        deleteItemUseCase.executeAsync(item){
            notification.value = it.notification
            listItems.value = it.output ?: emptyList()
        }
    }

}