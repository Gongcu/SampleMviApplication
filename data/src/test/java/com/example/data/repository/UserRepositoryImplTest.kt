package com.example.data.repository

import com.example.data.DataLayerMockData
import com.example.data.source.local.user.UserLocalDataSource
import com.example.data.source.remote.user.UserRemoteDataSource
import com.example.domain.MockData
import com.example.domain.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import java.lang.Exception
import kotlin.math.log

class UserRepositoryImplTest {
    private lateinit var localDataSource: UserLocalDataSource
    private lateinit var remoteDataSource: UserRemoteDataSource
    private lateinit var userRepositoryImpl: UserRepository

    @Before
    fun setUp() {
        localDataSource = mockk(relaxed = true)
        remoteDataSource = mockk(relaxed = true)
        userRepositoryImpl = UserRepositoryImpl(
            localDataSource,
            remoteDataSource
        )
    }

    @Test
    fun getUsersTest() {
        every {
            localDataSource.getUsers()
        } returns DataLayerMockData.userEntitiesSingle
        every {
            remoteDataSource.getUsers()
        } returns DataLayerMockData.userEntitiesSingle

        userRepositoryImpl.getUsers()
            .test()
            .assertValue(MockData.users)
            .assertComplete()
            .assertNoErrors()

        verify { localDataSource.getUsers() }
        verify { remoteDataSource.getUsers() }
    }

    @Test
    fun getUsersTest_whenLocalSourceListEmpty() {
        every {
            localDataSource.getUsers()
        } returns DataLayerMockData.emptyUserEntitiesSingle
        every {
            remoteDataSource.getUsers()
        } returns DataLayerMockData.userEntitiesSingle

        userRepositoryImpl.getUsers()
            .test()
            .assertValue(MockData.users)
            .assertComplete()
            .assertNoErrors()

        verify { localDataSource.getUsers() }
        verify { remoteDataSource.getUsers() }
    }

    @Test
    fun getUserDetailsTest() {
        val loginId = MockData.loginId
        every {
            localDataSource.getUserDetails(any())
        } returns DataLayerMockData.userDetailsEntitySingle

        userRepositoryImpl.getUserDetails(loginId)
            .test()
            .assertValue(MockData.userDetails)
            .assertComplete()
            .assertNoErrors()

        verify { localDataSource.getUserDetails(any()) }
    }

    @Test
    fun getUsersFromRemoteTest() {
        every {
            remoteDataSource.getUsers()
        } returns DataLayerMockData.userEntitiesSingle

        userRepositoryImpl.getUsersFromRemote()
            .test()
            .assertValue(MockData.users)
            .assertComplete()
            .assertNoErrors()

        verify { remoteDataSource.getUsers() }
        verify { localDataSource.insertUsers(any()) }
    }

    @Test
    fun getUserDetailsFromRemoteTest() {
        val loginId = MockData.loginId
        every {
            remoteDataSource.getUserDetails(any())
        } returns DataLayerMockData.userDetailsEntitySingle

        userRepositoryImpl.getUserDetailsFromRemote(loginId)
            .test()
            .assertValue(MockData.userDetails)
            .assertComplete()
            .assertNoErrors()

        verify { remoteDataSource.getUserDetails(any()) }
        verify { localDataSource.insertUserDetails(any()) }
    }

    @Test
    fun getUsersFromLocalTest() {
        every {
            localDataSource.getUsers()
        } returns DataLayerMockData.userEntitiesSingle

        userRepositoryImpl.getUsersFromLocal()
            .test()
            .assertValue(MockData.users)
            .assertComplete()
            .assertNoErrors()

        verify { localDataSource.getUsers() }
    }

    @Test
    fun getUserDetailsFromLocalTest() {
        val loginId = MockData.loginId
        every {
            localDataSource.getUserDetails(any())
        } returns DataLayerMockData.userDetailsEntitySingle

        userRepositoryImpl.getUserDetailsFromLocal(loginId)
            .test()
            .assertValue(MockData.userDetails)
            .assertComplete()
            .assertNoErrors()

        verify { localDataSource.getUserDetails(any()) }
    }
}