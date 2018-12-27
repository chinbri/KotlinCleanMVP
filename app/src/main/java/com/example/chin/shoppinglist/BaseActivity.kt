package com.example.chin.shoppinglist

import android.support.v7.app.AppCompatActivity
import com.example.chin.shoppinglist.di.ActivityComponent
import com.example.chin.shoppinglist.di.ActivityModule
import com.example.chin.shoppinglist.di.DaggerActivityComponent
import kotlinx.coroutines.Job

abstract class BaseActivity: AppCompatActivity() {

    val job: Job = Job()

    val activityComponent : ActivityComponent by lazy{
        DaggerActivityComponent.builder()
            .applicationComponent((application as ShoppingApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
    }

    override fun onPause() {
        super.onPause()
        job.cancel()
    }
}