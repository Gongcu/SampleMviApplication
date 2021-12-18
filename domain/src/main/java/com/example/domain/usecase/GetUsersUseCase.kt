package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Flowable

class GetUsersUseCase(
    private val repository: UserRepository
) {
    fun execute(): Flowable<List<User>> = repository.getUsers()
}