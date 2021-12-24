package com.example.samplemviapplication.di

import com.example.samplemviapplication.App
import com.example.presentation.di.module.ActivityBindingModule
import com.example.samplemviapplication.di.module.AppModule
import com.example.presentation.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    ViewModelModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>
}