package com.example.domain.usecase

import com.example.domain.model.UserDetails
import com.example.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Single

class GetUserDetailsUseCase(
    private val repository: UserRepository
) {
    fun execute(login: String): Single<UserDetails> = repository.getUserDetails(login)
}