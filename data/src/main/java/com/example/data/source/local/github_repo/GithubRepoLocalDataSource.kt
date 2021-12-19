package com.example.data.source.local.github_repo

import com.example.data.dto.GithubRepoEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface GithubRepoLocalDataSource {
    fun getGithubRepo(id: Int): Single<GithubRepoEntity>
    fun getGithubRepos(): Single<List<GithubRepoEntity>>
    fun insertGithubRepo(githubRepoEntity: GithubRepoEntity) : Completable
    fun insertGithubRepos(githubRepoEntities: List<GithubRepoEntity>) : Completable
}