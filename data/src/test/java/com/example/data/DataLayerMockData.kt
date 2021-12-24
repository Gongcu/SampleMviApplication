package com.example.data

import com.example.data.dto.GithubRepoEntity
import com.example.data.dto.UserDetailsEntity
import com.example.data.dto.UserEntity
import com.example.data.mapper.mapperToGithubRepoEntity
import com.example.data.mapper.mapperToUserDetailsEntity
import com.example.data.mapper.mapperToUserEntity
import com.example.domain.MockData

import io.reactivex.rxjava3.core.Single

object DataLayerMockData {
    val repoId = 1
    val githubRepoEntity: GithubRepoEntity
    = MockData.githubRepos.mapperToGithubRepoEntity().first()
    val githubRepoEntitySingle: Single<GithubRepoEntity>
    = Single.just(githubRepoEntity)


    val githubRepoEntities = MockData.githubRepos.mapperToGithubRepoEntity()
    val githubRepsEntitiesSingle: Single<List<GithubRepoEntity>>
     = Single.just(githubRepoEntities)

    val emptyGithubRepoEntitiesSingle: Single<List<GithubRepoEntity>>
     = Single.just(listOf())

    private val userEntities = MockData.users.mapperToUserEntity()
    val userEntitiesSingle: Single<List<UserEntity>>
            = Single.just(userEntities)

    val emptyUserEntitiesSingle: Single<List<UserEntity>>
            = Single.just(listOf())

    val userDetailsEntity = MockData.userDetails.mapperToUserDetailsEntity()
    val userDetailsEntitySingle: Single<UserDetailsEntity>
            = Single.just(userDetailsEntity)
}