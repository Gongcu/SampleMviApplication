package com.example.samplemviapplication.di.module

import com.example.domain.repository.GithubRepoRepository
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.GetGithubRepoUseCase
import com.example.domain.usecase.GetUsersUseCase
import com.example.domain.usecase.GetUserDetailsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UseCaseModule {
    @Singleton
    @Provides
    fun provideGetGithubRepoUseCase(
        githubRepoRepository: GithubRepoRepository
    ): GetGithubRepoUseCase
    = GetGithubRepoUseCase(githubRepoRepository)

    @Singleton
    @Provides
    fun provideGetUsersUseCase(
        userRepository: UserRepository
    ): GetUsersUseCase
            = GetUsersUseCase(userRepository)

    @Singleton
    @Provides
    fun provideGetUserDetailsUseCase(
        userRepository: UserRepository
    ): GetUserDetailsUseCase
            = GetUserDetailsUseCase(userRepository)
}