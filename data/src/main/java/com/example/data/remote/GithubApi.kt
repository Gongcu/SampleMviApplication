package com.example.data.remote

import com.example.data.dto.GithubRepoEntity
import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface GithubApi {
    @GET("/users")
    fun getUsers() : Single<List<UserEntity>>

    @GET("/users/:login")
    fun getUserDetails(login: String) : Single<UserDetailsEntity>

    @GET("/repositories")
    fun getGithubRepos(authToken: String) : Single<List<GithubRepoEntity>>
    //https://docs.github.com/en/rest/reference/repos#list-public-repositories
}