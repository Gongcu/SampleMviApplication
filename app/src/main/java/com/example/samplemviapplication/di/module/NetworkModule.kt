package com.example.samplemviapplication.di.module

import com.example.data.remote.GithubApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {
    private const val API_URL = "https://api.github.com"

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(API_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubApi(retrofit: Retrofit) : GithubApi
        = retrofit.create(GithubApi::class.java)
}