package com.example.samplemviapplication.di.module

import com.example.data.db.GithubRepoDao
import com.example.data.db.UserDao
import com.example.data.remote.GithubApi
import com.example.data.source.local.github_repo.GithubRepoLocalDataSource
import com.example.data.source.local.github_repo.GithubRepoLocalDataSourceImpl
import com.example.data.source.local.user.UserLocalDataSource
import com.example.data.source.local.user.UserLocalDataSourceImpl
import com.example.data.source.remote.github_repo.GithubRepoRemoteDataSource
import com.example.data.source.remote.github_repo.GithubRepoRemoteDataSourceImpl
import com.example.data.source.remote.user.UserRemoteDataSource
import com.example.data.source.remote.user.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DataSourceModule {
    companion object {
        @Provides
        @Singleton
        fun provideUserLocalDataSource(
            userDao: UserDao
        ):UserLocalDataSource = UserLocalDataSourceImpl(userDao)

        @Provides
        @Singleton
        fun provideUserRemoteDataSource(
            githubApi: GithubApi
        ):UserRemoteDataSource = UserRemoteDataSourceImpl(githubApi)

        @Provides
        @Singleton
        fun provideGithubRepoLocalDataSource(
            githubRepoDao: GithubRepoDao
        ): GithubRepoLocalDataSource = GithubRepoLocalDataSourceImpl(githubRepoDao)

        @Provides
        @Singleton
        fun provideGithubRepoRemoteDataSource(
            githubApi: GithubApi
        ): GithubRepoRemoteDataSource = GithubRepoRemoteDataSourceImpl(githubApi)
    }
}