package com.example.presentation.di.module

import com.example.presentation.users.UsersActivity
import com.example.presentation.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun provideMainActivity() : UsersActivity
}