package com.example.chin.shoppinglist

import android.os.Bundle
import android.widget.Toast
import com.example.chin.presentation.main.MainPresenter
import com.example.chin.presentation.main.MainView
import com.example.chin.shoppinglist.di.main.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent
            .mainComponentBuilder()
            .mainModule(MainModule()).build()
            .inject(this)

        presenter.initialize(this)

        setupView()
    }

    private fun setupView() {
        btnSayHi.setOnClickListener{
            presenter.sayHi()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
