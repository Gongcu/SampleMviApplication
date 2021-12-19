package com.example.data.source.remote.user

import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity
import io.reactivex.rxjava3.core.Single

interface UserRemoteDataSource {
    fun getUsers() : Single<List<UserEntity>>
    fun getUserDetails(login: String) : Single<UserDetailsEntity>
}