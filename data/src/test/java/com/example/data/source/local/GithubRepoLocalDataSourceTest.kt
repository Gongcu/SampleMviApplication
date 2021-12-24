package com.example.data.source.local

import com.example.data.DataLayerMockData
import com.example.data.db.GithubRepoDao
import com.example.data.source.local.github_repo.GithubRepoLocalDataSource
import com.example.data.source.local.github_repo.GithubRepoLocalDataSourceImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Completable
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GithubRepoLocalDataSourceTest {
    private lateinit var githubRepoDao: GithubRepoDao
    private lateinit var githubRepoLocalDataSource: GithubRepoLocalDataSource

    @Before
    fun setUp() {
        githubRepoDao = mockk(relaxed = true)
        githubRepoLocalDataSource = GithubRepoLocalDataSourceImpl(githubRepoDao)
    }

    @Test
    fun getGithubRepoTest() {
        every { githubRepoDao.getGithubRepo(any()) } returns DataLayerMockData.githubRepoEntitySingle

        val expected = DataLayerMockData.githubRepoEntitySingle
        val actual = githubRepoLocalDataSource.getGithubRepo(DataLayerMockData.repoId)

        Assert.assertEquals(expected, actual)

        verify { githubRepoDao.getGithubRepo(any()) }
    }

    @Test
    fun getGithubReposTest() {
        every { githubRepoDao.getGithubRepos() } returns DataLayerMockData.githubRepsEntitiesSingle

        val expected = DataLayerMockData.githubRepsEntitiesSingle
        val actual = githubRepoLocalDataSource.getGithubRepos()

        Assert.assertEquals(expected, actual)

        verify { githubRepoDao.getGithubRepos() }
    }

    @Test
    fun insertGithubRepoTest() {
        every { githubRepoDao.insertGithubRepo(any()) } returns Completable.complete()

        githubRepoLocalDataSource.insertGithubRepo(DataLayerMockData.githubRepoEntity)
            .test()
            .assertComplete()

        verify { githubRepoDao.insertGithubRepo(any()) }
    }

    @Test
    fun insertGithubReposTest() {
        every { githubRepoDao.insertGithubRepos(any()) } returns Completable.complete()

        githubRepoLocalDataSource.insertGithubRepos(DataLayerMockData.githubRepoEntities)
            .test()
            .assertComplete()

        verify { githubRepoDao.insertGithubRepos(any()) }
    }
}