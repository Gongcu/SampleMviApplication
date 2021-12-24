package com.example.data.source.remote

import com.example.data.DataLayerMockData
import com.example.data.remote.GithubApi
import com.example.data.source.remote.github_repo.GithubRepoRemoteDataSource
import com.example.data.source.remote.github_repo.GithubRepoRemoteDataSourceImpl
import com.example.domain.MockData
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GithubRepoRemoteDataSourceTest {
    private lateinit var githubApi: GithubApi
    private lateinit var githubRepoRemoteDataSource: GithubRepoRemoteDataSource

    @Before
    fun setUp() {
        githubApi = mockk(relaxed = true)
        githubRepoRemoteDataSource = GithubRepoRemoteDataSourceImpl(githubApi)
    }

    @Test
    fun getGithubReposTest() {
        every { githubApi.getGithubRepos(any()) } returns DataLayerMockData.githubRepsEntitiesSingle

        val expected = DataLayerMockData.githubRepsEntitiesSingle
        val actual = githubRepoRemoteDataSource.getGithubRepos(MockData.authToken)

        Assert.assertEquals(expected, actual)

        verify { githubApi.getGithubRepos(any()) }
    }
}