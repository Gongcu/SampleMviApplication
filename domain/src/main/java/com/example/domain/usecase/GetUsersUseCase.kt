package com.example.domain.usecase

import com.example.domain.model.GithubRepo
import com.example.domain.model.User
import com.example.domain.repository.Repository
import io.reactivex.rxjava3.core.Flowable

class GetUsersUseCase(
    private val repository: Repository
) {
    fun execute(): Flowable<List<User>> = repository.getUsers()
}