package com.example.chin.shoppinglist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chin.presentation.main.MainPresenter
import com.example.chin.shoppinglist.di.ActivityModule
import com.example.chin.shoppinglist.di.DaggerActivityComponent
import com.example.chin.shoppinglist.di.main.MainModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerActivityComponent.builder()
            .applicationComponent((application as ShoppingApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build().mainComponentBuilder()
            .mainModule(MainModule()).build()
            .inject(this)

        presenter.sayHi()
    }
}
