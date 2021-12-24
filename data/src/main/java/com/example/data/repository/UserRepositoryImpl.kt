package com.example.data.repository

import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity
import com.example.data.mapper.mapperToUser
import com.example.data.mapper.mapperToUserDetails
import com.example.data.source.local.user.UserLocalDataSource
import com.example.data.source.local.user.UserLocalDataSourceImpl
import com.example.data.source.remote.user.UserRemoteDataSource
import com.example.data.source.remote.user.UserRemoteDataSourceImpl
import com.example.domain.model.GithubRepo
import com.example.domain.model.User
import com.example.domain.model.UserDetails
import com.example.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import java.lang.IllegalStateException

class UserRepositoryImpl(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override fun getUsers(): Flowable<List<User>> {
        return localDataSource.getUsers()
            .onErrorReturn { listOf<UserEntity>() }
            .flatMapPublisher {
                if(it.isEmpty())
                    getUsersFromRemote()
                        .toFlowable()
                else {
                    val local = Single.just(it.mapperToUser())
                    val remote = getUsersFromRemote()
                    Single.concat<List<User>>(local, remote)
                        .distinct()
                }
            }
    }

    override fun getUserDetails(login: String): Single<UserDetails> {
        return localDataSource.getUserDetails(login)
            .map { it.mapperToUserDetails() }
            .doOnError {
                remoteDataSource.getUserDetails(login)
            }
    }

    override fun getUsersFromRemote(): Single<List<User>> {
        return remoteDataSource.getUsers()
            .flatMap {
                localDataSource.insertUsers(it)
                Single.just(it.mapperToUser())
            }
    }

    override fun getUserDetailsFromRemote(login: String): Single<UserDetails> {
        return remoteDataSource.getUserDetails(login)
            .flatMap {
                localDataSource.insertUserDetails(it)
                Single.just(it.mapperToUserDetails())
            }
    }

    override fun getUsersFromLocal(): Flowable<List<User>> {
        return localDataSource.getUsers()
            .onErrorReturn { listOf<UserEntity>()}
            .flatMapPublisher {
                if(it.isEmpty())
                    Flowable.error(IllegalStateException("No Data In Local"))
                else
                    Flowable.just(it.mapperToUser())
            }
    }

    override fun getUserDetailsFromLocal(login: String): Single<UserDetails> {
        return localDataSource.getUserDetails(login)
            .map(UserDetailsEntity::mapperToUserDetails)
    }
}