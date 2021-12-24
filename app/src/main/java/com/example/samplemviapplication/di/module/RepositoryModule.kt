package com.example.samplemviapplication.di.module

import com.example.data.repository.GithubRepoRepositoryImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.data.source.local.github_repo.GithubRepoLocalDataSource
import com.example.data.source.local.user.UserLocalDataSource
import com.example.data.source.remote.github_repo.GithubRepoRemoteDataSource
import com.example.data.source.remote.user.UserRemoteDataSource
import com.example.domain.repository.GithubRepoRepository
import com.example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    companion object {
        @Provides
        @Singleton
        fun provideUserRepository(
            localDataSource: UserLocalDataSource,
            remoteDataSource: UserRemoteDataSource,
        ):UserRepository
        = UserRepositoryImpl(localDataSource, remoteDataSource)

        @Provides
        @Singleton
        fun provideGithubRepoRepository(
            localDataSource: GithubRepoLocalDataSource,
            remoteDataSource: GithubRepoRemoteDataSource,
        ):GithubRepoRepository
                = GithubRepoRepositoryImpl(localDataSource, remoteDataSource)
    }
}