package com.example.domain.usecase

import com.example.domain.MockData
import com.example.domain.repository.GithubRepoRepository
import com.example.domain.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class GetUserDetailsUseCaseTest {
    private lateinit var repository: UserRepository
    private lateinit var getUserDetailsUseCase: GetUserDetailsUseCase

    @Before
    fun setUp(){
        repository = mockk(relaxed = true)
        getUserDetailsUseCase = GetUserDetailsUseCase(repository)
    }

    @Test
    fun executeTest() {
        every { repository.getUserDetails(any()) } returns MockData.userDetailsSingle

        getUserDetailsUseCase.execute(MockData.loginId)
            .test()
            .assertValues(MockData.userDetails)
            .assertComplete()
            .assertNoErrors()

        verify { repository.getUserDetails(any()) }
    }
}