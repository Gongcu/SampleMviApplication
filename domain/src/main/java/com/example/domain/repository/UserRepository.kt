package com.example.domain.repository

import com.example.domain.model.User
import com.example.domain.model.UserDetails
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUsers(): Flowable<List<User>>
    fun getUserDetails(login: String): Single<UserDetails>
    fun getUsersFromRemote(): Single<List<User>>
    fun getUserDetailsFromRemote(login: String): Single<UserDetails>
    fun getUsersFromLocal(): Flowable<List<User>>
    fun getUserDetailsFromLocal(login: String): Single<UserDetails>
}