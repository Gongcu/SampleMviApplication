package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.dto.GithubRepoEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface GithubRepoDao {
    @Query("SELECT * FROM github_repos")
    fun getGithubRepos() : Single<List<GithubRepoEntity>>

    @Query("SELECT * FROM github_repos WHERE id=:id")
    fun getGithubRepo(id: Int): Single<GithubRepoEntity>

    @Insert
    fun insertGithubRepos(githubRepoEntities: List<GithubRepoEntity>): Completable

    @Insert
    fun insertGithubRepo(githubRepoEntity: GithubRepoEntity): Completable
}