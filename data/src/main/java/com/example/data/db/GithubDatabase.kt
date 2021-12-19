package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dto.GithubRepoEntity
import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity

@Database(entities =
[
    UserEntity::class,
    UserDetailsEntity::class,
    GithubRepoEntity::class
],
    version = 1,
    exportSchema = false)
abstract class GithubDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun githubRepoDao(): GithubRepoDao
}