package com.example.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_details")
data class UserDetailsEntity(
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("avatar_url")
    val imageUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("followings")
    val followings: Int,
    @SerializedName("followers")
    val followers: Int,
)
