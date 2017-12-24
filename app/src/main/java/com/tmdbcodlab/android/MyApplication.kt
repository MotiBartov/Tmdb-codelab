package com.tmdbcodlab.android

import android.app.Application
import timber.log.Timber

class MyApplication : Application() {

    lateinit var component : AppComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        component = DaggerAppComponent.builder().
                appModule(AppModule(this))
                .build()
    }

    fun getAppComponent() : AppComponent{
        return component
    }
}