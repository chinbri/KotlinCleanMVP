package com.example.chin.presentation.main

import com.example.chin.domain.main.MainUseCase
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(val mainUseCase: MainUseCase) : MainPresenter {

    override fun sayHi() {
        println("now call use case")
        mainUseCase.executeAsync("test"){
            println(it)
        }

        println("thead not blocked :D")
    }
}