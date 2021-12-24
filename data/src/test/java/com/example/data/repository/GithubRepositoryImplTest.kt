package com.example.data.repository

import com.example.data.DataLayerMockData
import com.example.data.source.local.github_repo.GithubRepoLocalDataSource
import com.example.data.source.remote.github_repo.GithubRepoRemoteDataSource
import com.example.domain.MockData
import com.example.domain.repository.GithubRepoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class GithubRepositoryImplTest {
    private lateinit var localDataSource: GithubRepoLocalDataSource
    private lateinit var remoteDataSource: GithubRepoRemoteDataSource
    private lateinit var githubRepoRepositoryImpl: GithubRepoRepository

    @Before
    fun setUp() {
        localDataSource = mockk(relaxed = true)
        remoteDataSource = mockk(relaxed = true)
        githubRepoRepositoryImpl = GithubRepoRepositoryImpl(
            localDataSource,
            remoteDataSource
        )
    }

    @Test
    fun getGithubReposTest() {
        val authToken = MockData.authToken

        every {
            localDataSource.getGithubRepos()
        } returns DataLayerMockData.githubRepsEntitiesSingle

        every {
            remoteDataSource.getGithubRepos(any())
        } returns DataLayerMockData.githubRepsEntitiesSingle

        githubRepoRepositoryImpl.getGithubRepos(authToken)
            .test()
            .assertValue(MockData.githubRepos)
            .assertComplete()
            .assertNoErrors()

        verify { localDataSource.getGithubRepos() }
        verify { remoteDataSource.getGithubRepos(any()) }

    }

    @Test
    fun getGithubReposTest_whenLocalSourceListEmpty() {
        val authToken = MockData.authToken

        every {
            localDataSource.getGithubRepos()
        } returns DataLayerMockData.emptyGithubRepoEntitiesSingle

        every {
            remoteDataSource.getGithubRepos(any())
        } returns DataLayerMockData.githubRepsEntitiesSingle

        githubRepoRepositoryImpl.getGithubRepos(authToken)
            .test()
            .assertValue(MockData.githubRepos)
            .assertComplete()
            .assertNoErrors()

        verify { localDataSource.getGithubRepos() }
        verify { remoteDataSource.getGithubRepos(any()) }
    }

    @Test
    fun getGithubReposFromLocalTest() {
        every {
            localDataSource.getGithubRepos()
        } returns DataLayerMockData.githubRepsEntitiesSingle

        githubRepoRepositoryImpl.getGithubReposFromLocal()
            .test()
            .assertValue(MockData.githubRepos)
            .assertComplete()
            .assertNoErrors()

        verify { localDataSource.getGithubRepos() }
    }

    @Test
    fun getGithubReposFromRemoteTest() {
        val authToken = MockData.authToken
        every {
            remoteDataSource.getGithubRepos(any())
        } returns DataLayerMockData.githubRepsEntitiesSingle

        githubRepoRepositoryImpl.getGithubReposFromRemote(authToken)
            .test()
            .assertValue(MockData.githubRepos)
            .assertComplete()
            .assertNoErrors()

        verify { remoteDataSource.getGithubRepos(any()) }
        verify { localDataSource.insertGithubRepos(any()) }
    }
}