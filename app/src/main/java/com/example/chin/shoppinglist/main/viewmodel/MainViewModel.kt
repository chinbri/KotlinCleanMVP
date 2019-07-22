package com.example.chin.shoppinglist.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chin.domain.*
import com.example.chin.domain.entities.ShoppingItem
import kotlinx.coroutines.Job

class MainViewModel(val obtainListUseCase: ObtainListUseCase,
                    val addItemOrUpdateUseCase: AddItemOrUpdateUseCase,
                    val deleteItemUseCase: DeleteItemUseCase): ViewModel() {

    lateinit var viewJob: Job

    var eventNotification: MutableLiveData<Event<UseCaseNotification>?> = MutableLiveData()
    var listItems: MutableLiveData<List<ShoppingItem>> = MutableLiveData()

    fun obtainList() {
        obtainListUseCase.executeAsync(Unit, viewJob) {
            eventNotification.value = it.event
            listItems.value = it.output ?: emptyList()
        }
    }

    fun addItem(shoppingItem: ShoppingItem) {
        addItemOrUpdateUseCase.executeAsync(shoppingItem, viewJob){
            eventNotification.value = it.event

            if(!it.existEventNotification()){
                obtainList()
            }
        }
    }

    fun onItemSelected(shoppingItem: ShoppingItem) {
        addItemOrUpdateUseCase.executeAsync(shoppingItem, viewJob){

            eventNotification.value = it.event

            if(!it.existEventNotification()){
                obtainList()
            }
        }
    }

    fun onItemDeleted(item: ShoppingItem) {
        deleteItemUseCase.executeAsync(item, viewJob){
            eventNotification.value = it.event
            listItems.value = it.output ?: emptyList()
        }
    }

}