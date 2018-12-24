package com.example.chin.shoppinglist.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: Activity) {


    @Provides
    @ActivityScope
    fun providesContext(): Context {
        return activity
    }

    @Provides
    @ActivityScope
    fun providesActivity(): Activity {
        return activity
    }


}