package com.example.chin.shoppinglist

import android.os.Bundle
import com.example.chin.presentation.main.MainPresenter
import com.example.chin.shoppinglist.di.main.MainModule
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent
            .mainComponentBuilder()
            .mainModule(MainModule()).build()
            .inject(this)

        presenter.sayHi()
    }
}
