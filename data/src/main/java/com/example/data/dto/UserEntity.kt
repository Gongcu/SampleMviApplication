package com.example.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserEntity(
    @SerializedName("login") val login: String,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("avatar_url")
    val imageUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
)
