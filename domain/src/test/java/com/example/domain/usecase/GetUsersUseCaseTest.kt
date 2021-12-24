package com.example.domain.usecase

import com.example.domain.MockData
import com.example.domain.repository.GithubRepoRepository
import com.example.domain.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class GetUsersUseCaseTest {
    private lateinit var repository: UserRepository
    private lateinit var getUsersUseCase: GetUsersUseCase

    @Before
    fun setUp(){
        repository = mockk(relaxed = true)
        getUsersUseCase = GetUsersUseCase(repository)
    }

    @Test
    fun executeTest() {
        every { repository.getUsers() } returns MockData.usersFlowable

        getUsersUseCase.execute()
            .test()
            .assertValues(MockData.users)
            .assertComplete()
            .assertNoErrors()

        verify { repository.getUsers() }
    }
}