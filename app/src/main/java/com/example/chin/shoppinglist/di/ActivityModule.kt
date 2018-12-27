package com.example.chin.shoppinglist.di

import android.content.Context
import com.example.chin.shoppinglist.BaseActivity
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Job

@Module
class ActivityModule(val activity: BaseActivity) {

    @Provides
    @ActivityScope
    fun providesContext(): Context {
        return activity
    }

    @Provides
    @ActivityScope
    fun providesActivity(): BaseActivity {
        return activity
    }

    @Provides
    @ActivityScope
    fun providesActivityJob(): Job {
        return activity.job
    }


}