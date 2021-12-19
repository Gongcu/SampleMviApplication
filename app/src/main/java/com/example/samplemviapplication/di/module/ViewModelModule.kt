package com.example.samplemviapplication.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.samplemviapplication.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) :  ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(LoginViewModel::class)
//    internal abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}