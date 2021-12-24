package com.example.samplemviapplication.di.module

import android.content.Context
import androidx.room.Room
import com.example.data.db.GithubDatabase
import com.example.data.db.GithubRepoDao
import com.example.data.db.UserDao
import com.example.samplemviapplication.di.module.qualifer.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DbModule {
    private const val DB_NAME = "GITHUB"
    @Provides
    @Singleton
    fun provideDb(
        @ApplicationContext context: Context
    ): GithubDatabase = Room.databaseBuilder(
        context,
        GithubDatabase::class.java,
        DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideGithubRepoDao(
        db: GithubDatabase
    ): GithubRepoDao = db.githubRepoDao()

    @Provides
    @Singleton
    fun provideUserDao(
        db: GithubDatabase
    ):UserDao = db.userDao()
}