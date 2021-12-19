package com.example.samplemviapplication

import com.example.samplemviapplication.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class App: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
