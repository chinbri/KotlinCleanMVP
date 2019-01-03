package com.example.chin.presentation.main

import com.example.chin.domain.add.AddItemUseCase
import com.example.chin.domain.main.ObtainListUseCase
import com.example.chin.presentation.navigator.Navigator
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val navigator: Navigator,
    private val obtainListUseCase: ObtainListUseCase,
    private val addItemUseCase: AddItemUseCase
) : MainPresenter {

    lateinit var view: MainView

    override fun initialize(view: MainView) {
        this.view = view
        obtainList()
    }

    private fun obtainList() {
        obtainListUseCase.executeAsync(Unit) {
            view.drawList(it)
        }
    }

    override fun addItem() {
        navigator.displayAddItemDialog(
            {
                addItemUseCase.executeAsync(it){
                    obtainList()
                }
            }
        )
    }
}