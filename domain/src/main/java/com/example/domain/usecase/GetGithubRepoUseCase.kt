package com.example.domain.usecase

import com.example.domain.model.GithubRepo
import com.example.domain.repository.Repository
import io.reactivex.rxjava3.core.Flowable

class GetGithubRepoUseCase(
    private val repository: Repository
) {
    fun execute(owner: String): Flowable<List<GithubRepo>> = repository.getGithubRepos(owner)
}