package com.example.samplemviapplication.di.module

import android.app.Application
import android.content.Context
import com.example.samplemviapplication.App
import com.example.samplemviapplication.di.module.qualifer.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class,
        DbModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindsApp(application: App) : Application


    companion object {
        @Provides
        @Singleton
        @ApplicationContext
        fun provideAppContext(application: App) : Context {
            return application
        }
    }
}