package com.example.domain.model

data class UserDetails(
    val login: String,
    val name: String,
    val id: Int,
    val imageUrl: String,
    val htmlUrl: String,
    val company: String,
    val location: String,
    val followings: Int,
    val followers: Int,
)

