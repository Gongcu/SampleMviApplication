package com.example.presentation.main

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetUsersUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getUsersUseCase: GetUsersUseCase
): ViewModel() {
}