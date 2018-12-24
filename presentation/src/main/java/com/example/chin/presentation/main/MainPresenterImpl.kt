package com.example.chin.presentation.main

import javax.inject.Inject

class MainPresenterImpl: MainPresenter {

    @Inject
    constructor()

    override fun sayHi() {
        println("IT WORKS!!!!!!!!!!!")
    }
}