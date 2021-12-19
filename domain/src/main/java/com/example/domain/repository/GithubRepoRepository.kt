package com.example.domain.repository

import com.example.domain.model.GithubRepo
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface GithubRepoRepository {
    fun getGithubRepos(authToken: String): Flowable<List<GithubRepo>>
    fun getGithubReposFromLocal(): Flowable<List<GithubRepo>>
    fun getGithubReposFromRemote(authToken: String): Single<List<GithubRepo>>
}