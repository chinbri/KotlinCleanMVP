package com.example.chin.presentation.main

import com.example.chin.domain.AddItemOrUpdateUseCase
import com.example.chin.domain.DeleteItemUseCase
import com.example.chin.domain.ObtainListUseCase
import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.presentation.navigator.Navigator
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val navigator: Navigator,
    private val obtainListUseCase: ObtainListUseCase,
    private val addItemOrUpdateUseCase: AddItemOrUpdateUseCase,
    private val deleteItemUseCase: DeleteItemUseCase
) : MainPresenter {

    lateinit var view: MainView

    override fun initialize(view: MainView) {
        this.view = view
        obtainList()
    }

    private fun obtainList() {
        obtainListUseCase.executeAsync(Unit) {
            view.drawList(it.output ?: emptyList())
        }
    }

    override fun addItem() {
        navigator.displayAddItemDialog(
            {
                addItemOrUpdateUseCase.executeAsync(it){ useCaseResponse ->
                    if(useCaseResponse.existNotification()){
                        view.showMessage("Duplicated item")
                    }else{
                        obtainList()
                    }
                }
            }
        )
    }

    override fun onItemSelected(item: ShoppingItem) {
        navigator.displayAddItemDialog(
            {
                addItemOrUpdateUseCase.executeAsync(it){
                    obtainList()
                }
            },
            item
        )
    }

    override fun onItemDeleted(item: ShoppingItem) {
        //TODO ask user confirmation before delete
        deleteItemUseCase.executeAsync(item){
            view.drawList(it.output ?: emptyList())
        }
    }
}