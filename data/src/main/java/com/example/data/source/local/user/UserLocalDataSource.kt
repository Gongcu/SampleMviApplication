package com.example.data.source.local.user

import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface UserLocalDataSource {
    fun getUsers() : Single<List<UserEntity>>
    fun getUserDetails(login: String) : Single<UserDetailsEntity>
    fun insertUsers(userEntities: List<UserEntity>): Completable
    fun insertUserDetails(userDetailsEntity: UserDetailsEntity): Completable
}