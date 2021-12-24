package com.example.data.source.remote

import com.example.data.DataLayerMockData
import com.example.data.remote.GithubApi
import com.example.data.source.remote.user.UserRemoteDataSource
import com.example.data.source.remote.user.UserRemoteDataSourceImpl
import com.example.domain.MockData
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserRemoteDataSourceTest {
    private lateinit var githubApi: GithubApi
    private lateinit var userRemoteDataSource: UserRemoteDataSource

    @Before
    fun setUp() {
        githubApi = mockk(relaxed = true)
        userRemoteDataSource = UserRemoteDataSourceImpl(githubApi)
    }

    @Test
    fun getUsersTest() {
        every { githubApi.getUsers() } returns DataLayerMockData.userEntitiesSingle

        val expected = DataLayerMockData.userEntitiesSingle
        val actual = userRemoteDataSource.getUsers()

        assertEquals(expected, actual)

        verify { githubApi.getUsers() }
    }

    @Test
    fun getUserDetailsTest() {
        every { githubApi.getUserDetails(any()) } returns DataLayerMockData.userDetailsEntitySingle

        val expected = DataLayerMockData.userDetailsEntitySingle
        val actual = userRemoteDataSource.getUserDetails(MockData.loginId)

        assertEquals(expected, actual)

        verify { githubApi.getUserDetails(any()) }
    }
}