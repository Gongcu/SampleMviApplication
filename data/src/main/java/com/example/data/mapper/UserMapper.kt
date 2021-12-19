package com.example.data.mapper

import com.example.data.dto.UserEntity
import com.example.domain.model.User

fun List<User>.mapperToUserEntity(): List<UserEntity> {
    return this.map {
        UserEntity(
            it.login,
            it.name,
            it.id,
            it.imageUrl,
            it.htmlUrl
        )
    }
}

fun List<UserEntity>.mapperToUser(): List<User> {
    return this.map {
        User(
            it.login,
            it.name,
            it.id,
            it.imageUrl,
            it.htmlUrl
        )
    }
}