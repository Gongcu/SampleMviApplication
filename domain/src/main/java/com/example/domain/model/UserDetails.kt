package com.example.domain.model

data class UserDetails(
    private val login: String,
    private val name: String,
    private val id: Int,
    private val imageUrl: String,
    private val company: String,
    private val location: String,
    private val followings: Int,
    private val followers: Int,
)

