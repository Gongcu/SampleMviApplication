package com.example.domain.usecase

import com.example.domain.model.GithubRepo
import com.example.domain.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Flowable

class GetGithubRepoUseCase(
    private val repository: GithubRepoRepository
) {
    fun execute(authToken: String): Flowable<List<GithubRepo>> = repository.getGithubRepos(authToken)
}