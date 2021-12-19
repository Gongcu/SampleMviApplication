package com.example.data.source.local.user

import com.example.data.db.UserDao
import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class UserLocalDataSourceImpl(
    private val userDao: UserDao
): UserLocalDataSource {
    override fun getUsers(): Single<List<UserEntity>> {
        return userDao.getUsers()
    }

    override fun getUserDetails(login: String): Single<UserDetailsEntity> {
        return userDao.getUserDetails(login)
    }

    override fun insertUsers(userEntities: List<UserEntity>): Completable {
        return userDao.insertUsers(userEntities)
    }

    override fun insertUserDetails(userDetailsEntity: UserDetailsEntity): Completable {
        return userDao.insertUserDetails(userDetailsEntity)
    }
}