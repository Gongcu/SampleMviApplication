package com.example.samplemviapplication.di.module.mapkey

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(value= AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)