package com.example.samplemviapplication.di.module

import android.app.Application
import android.content.Context
import com.example.samplemviapplication.App
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class
    ]
)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun provideApp(application: App) : Application

    @Binds
    @Singleton
    abstract fun provideContext(application: App) : Context
}