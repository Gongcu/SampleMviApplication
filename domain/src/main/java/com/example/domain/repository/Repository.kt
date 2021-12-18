package com.example.domain.repository

import com.example.domain.model.GithubRepo
import com.example.domain.model.User
import io.reactivex.rxjava3.core.Flowable

interface Repository {
    fun getGithubRepos(owner: String): Flowable<List<GithubRepo>>
    fun getUsers(): Flowable<List<User>>
}