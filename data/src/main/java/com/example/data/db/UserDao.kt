package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUsers() : Single<List<UserEntity>>

    @Query("SELECT * FROM user_details WHERE login=:login")
    fun getUserDetails(login: String): Single<UserDetailsEntity>

    @Insert(onConflict = REPLACE)
    fun insertUsers(userEntities: List<UserEntity>): Completable

    @Insert(onConflict = REPLACE)
    fun insertUserDetails(userDetailsEntity: UserDetailsEntity): Completable
}