package com.example.domain.model

data class User(
    private val login: String,
    private val name: String,
    private val id: Int,
    private val imageUrl: String,
    private val htmlUrl: String,
)
