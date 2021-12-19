package com.example.data.repository

import com.example.data.mapper.mapperToGithubRepo
import com.example.data.source.local.github_repo.GithubRepoLocalDataSource
import com.example.data.source.remote.github_repo.GithubRepoRemoteDataSource
import com.example.domain.model.GithubRepo
import com.example.domain.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import java.lang.IllegalStateException

class GithubRepoRepositoryImpl(
    private val localDataSource: GithubRepoLocalDataSource,
    private val remoteDataSource: GithubRepoRemoteDataSource
) : GithubRepoRepository {
    override fun getGithubRepos(authToken: String): Flowable<List<GithubRepo>> {
        return localDataSource.getGithubRepos()
            .flatMapPublisher {
                if (it.isEmpty()) {
                    getGithubReposFromRemote(authToken)
                        .toFlowable()
                } else {
                    val local = Single.just(it.mapperToGithubRepo())
                    val remote = getGithubReposFromRemote(authToken)
                    Single.concat(local, remote)
                }
            }
    }

    override fun getGithubReposFromLocal(): Flowable<List<GithubRepo>> {
        return localDataSource.getGithubRepos()
            .flatMapPublisher {
                if(it.isEmpty())
                    Flowable.error(IllegalStateException("No Data In Local"))
                else
                    Flowable.just(it.mapperToGithubRepo())
            }
    }

    override fun getGithubReposFromRemote(authToken: String): Single<List<GithubRepo>> {
        return remoteDataSource.getGithubRepos(authToken)
            .flatMap{
                localDataSource.insertGithubRepos(it)
                Single.just(it.mapperToGithubRepo())
            }
    }
}