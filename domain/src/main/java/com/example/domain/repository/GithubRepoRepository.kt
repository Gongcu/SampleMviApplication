package com.example.domain.repository

import com.example.domain.model.GithubRepo
import io.reactivex.rxjava3.core.Flowable

interface GithubRepoRepository {
    fun getGithubRepos(owner: String): Flowable<List<GithubRepo>>
}