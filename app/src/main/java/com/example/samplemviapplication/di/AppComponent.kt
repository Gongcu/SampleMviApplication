package com.example.samplemviapplication.di

import com.example.samplemviapplication.App
import com.example.samplemviapplication.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>
}