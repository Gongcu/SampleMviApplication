package com.example.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_repos")
data class GithubRepoEntity(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("date")
    val date: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("description")
    val description: String,
)
