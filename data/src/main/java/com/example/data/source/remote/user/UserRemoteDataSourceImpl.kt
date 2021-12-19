package com.example.data.source.remote.user

import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity
import com.example.data.remote.GithubApi
import io.reactivex.rxjava3.core.Single

class UserRemoteDataSourceImpl(
    private val githubApi: GithubApi
): UserRemoteDataSource {
    override fun getUsers(): Single<List<UserEntity>> {
        return githubApi.getUsers()
    }

    override fun getUserDetails(login: String): Single<UserDetailsEntity> {
        return githubApi.getUserDetails(login)
    }
}