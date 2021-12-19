package com.example.data.source.remote.github_repo

import com.example.data.dto.GithubRepoEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface GithubRepoRemoteDataSource {
    fun getGithubRepos(authToken: String): Single<List<GithubRepoEntity>>
}