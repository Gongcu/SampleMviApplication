package com.example.data.source.local.github_repo

import com.example.data.db.GithubRepoDao
import com.example.data.dto.GithubRepoEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class GithubRepoLocalDataSourceImpl(
    private val githubRepoDao: GithubRepoDao
): GithubRepoLocalDataSource {
    override fun getGithubRepo(id: Int): Single<GithubRepoEntity> {
        return githubRepoDao.getGithubRepo(id)
    }

    override fun getGithubRepos(): Single<List<GithubRepoEntity>> {
        return githubRepoDao.getGithubRepos()
    }

    override fun insertGithubRepo(githubRepoEntity: GithubRepoEntity): Completable {
        return githubRepoDao.insertGithubRepo(githubRepoEntity)
    }

    override fun insertGithubRepos(githubRepoEntities: List<GithubRepoEntity>): Completable {
        return githubRepoDao.insertGithubRepos(githubRepoEntities)
    }
}