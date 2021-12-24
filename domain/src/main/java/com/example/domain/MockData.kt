package com.example.domain

import com.example.domain.model.GithubRepo
import com.example.domain.model.User
import com.example.domain.model.UserDetails
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

object MockData {
    const val authToken = "MOCK_AUTO_TOKEN"
    val githubRepos = listOf(
        GithubRepo(
            name = "name1",
            id = 1,
            date = "2021.01.01",
            htmlUrl = "www.google.com",
            description = "first item",
        ),
        GithubRepo(
            name = "name2",
            id = 2,
            date = "2021.01.02",
            htmlUrl = "www.facebook.com",
            description = "second item",
        )
    )
    val githubReposFlowable: Flowable<List<GithubRepo>>
     = Flowable.just(githubRepos)

    val users = listOf(
        User(
            login ="login1",
            name = "name1",
            id = 1,
            imageUrl = "www.google.com",
            htmlUrl = "www.facebook.com",
        ),
        User(
            login ="login2",
            name = "name2",
            id = 2,
            imageUrl = "www.google.com",
            htmlUrl = "www.facebook.com",
        )
    )
    val usersFlowable: Flowable<List<User>>
            = Flowable.just(users)

    const val loginId = "MOCK_LOGIN_ID"
    val userDetails =
        UserDetails(
            login ="login1",
            name = "name1",
            id = 1,
            imageUrl = "www.google.com",
            htmlUrl = "www.facebook.com",
            company = "Buzzvil",
            location = "Seoul",
            followings = 1,
            followers = 2,
        )
    val userDetailsSingle: Single<UserDetails>
            = Single.just(userDetails)
}