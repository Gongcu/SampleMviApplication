package com.example.data.mapper

import com.example.data.dto.GithubRepoEntity
import com.example.data.dto.UserEntity
import com.example.domain.model.GithubRepo
import com.example.domain.model.User

fun List<GithubRepo>.mapperToGithubRepoEntity(): List<GithubRepoEntity> {
    return this.map {
        GithubRepoEntity(
            it.name,
            it.id,
            it.date,
            it.htmlUrl,
            it.description
        )
    }
}

fun List<GithubRepoEntity>.mapperToGithubRepo(): List<GithubRepo> {
    return this.map {
        GithubRepo(
            it.name,
            it.id,
            it.date,
            it.htmlUrl,
            it.description
        )
    }
}