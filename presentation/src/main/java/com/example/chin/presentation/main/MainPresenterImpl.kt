package com.example.chin.presentation.main

import com.example.chin.domain.main.MainUseCase
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(val mainUseCase: MainUseCase) : MainPresenter {

    lateinit var view: MainView

    override fun initialize(view: MainView) {
        this.view = view
    }

    override fun sayHi() {
        view.showMessage("calling use case...")
        mainUseCase.executeAsync("test"){
            view.showMessage(it)
        }

    }
}