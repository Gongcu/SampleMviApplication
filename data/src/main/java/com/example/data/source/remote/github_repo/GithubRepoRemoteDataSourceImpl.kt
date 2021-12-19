package com.example.data.source.remote.github_repo

import com.example.data.dto.GithubRepoEntity
import com.example.data.remote.GithubApi
import io.reactivex.rxjava3.core.Single

class GithubRepoRemoteDataSourceImpl(
    private val githubApi: GithubApi
): GithubRepoRemoteDataSource {
    override fun getGithubRepos(authToken: String): Single<List<GithubRepoEntity>> {
        return githubApi.getGithubRepos(authToken)
    }
}