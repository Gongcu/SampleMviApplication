package com.example.domain.usecase

import com.example.domain.MockData
import com.example.domain.repository.GithubRepoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class GetGithubRepoUseCaseTest {
    private lateinit var repository: GithubRepoRepository
    private lateinit var getGithubRepoUseCase: GetGithubRepoUseCase

    @Before
    fun setUp(){
        repository = mockk(relaxed = true)
        getGithubRepoUseCase = GetGithubRepoUseCase(repository)
    }

    @Test
    fun executeTest() {
        every { repository.getGithubRepos(any()) } returns MockData.githubReposFlowable

        getGithubRepoUseCase.execute(MockData.authToken)
            .test()
            .assertValues(MockData.githubRepos)
            .assertComplete()
            .assertNoErrors()

        verify { repository.getGithubRepos(any()) }
    }
}