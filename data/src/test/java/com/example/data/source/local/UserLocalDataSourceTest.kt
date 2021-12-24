package com.example.data.source.local

import com.example.data.DataLayerMockData
import com.example.data.db.UserDao
import com.example.data.mapper.mapperToUserEntity
import com.example.data.source.local.user.UserLocalDataSource
import com.example.data.source.local.user.UserLocalDataSourceImpl
import com.example.domain.MockData
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Completable
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserLocalDataSourceTest {
    private lateinit var userDao: UserDao
    private lateinit var userLocalDataSource: UserLocalDataSource

    @Before
    fun setUp() {
        userDao = mockk(relaxed = true)
        userLocalDataSource = UserLocalDataSourceImpl(userDao)
    }

    @Test
    fun getUsersTest() {
        every { userDao.getUsers() } returns DataLayerMockData.userEntitiesSingle

        val expected = DataLayerMockData.userEntitiesSingle
        val actual = userLocalDataSource.getUsers()

        Assert.assertEquals(expected, actual)

        verify { userDao.getUsers() }
    }

    @Test
    fun getUserDetailsTest() {
        every { userDao.getUserDetails(any()) } returns DataLayerMockData.userDetailsEntitySingle

        val expected = DataLayerMockData.userDetailsEntitySingle
        val actual = userLocalDataSource.getUserDetails(MockData.loginId)

        Assert.assertEquals(expected, actual)

        verify { userDao.getUserDetails(any()) }
    }

    @Test
    fun insertUsersTest() {
        every { userDao.insertUsers(any()) } returns Completable.complete()

        userLocalDataSource.insertUsers((MockData.users.mapperToUserEntity()))
            .test()
            .assertComplete()

        verify { userDao.insertUsers(any()) }
    }

    @Test
    fun insertUserDetailsTest() {
        every { userDao.insertUserDetails(any()) } returns Completable.complete()

        userLocalDataSource.insertUserDetails(DataLayerMockData.userDetailsEntity)
            .test()
            .assertComplete()

        verify { userDao.insertUserDetails(any()) }
    }
}