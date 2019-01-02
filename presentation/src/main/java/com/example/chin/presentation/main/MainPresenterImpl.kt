package com.example.chin.presentation.main

import com.example.chin.domain.main.ObtainListUseCase
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(val obtainListUseCase: ObtainListUseCase) : MainPresenter {

    lateinit var view: MainView

    override fun initialize(view: MainView) {
        this.view = view

        view.showMessage("calling use case...")
        obtainListUseCase.executeAsync("test"){
            view.showMessage("correcto")
            view.drawList(it)
        }
    }

    override fun addItem() {

    }
}