package com.example.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.User
import com.example.domain.usecase.GetUsersUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {
    sealed class ViewState {
        object Loading: ViewState()
        object Fetched: ViewState()
        object Error: ViewState()

        data class Users(val users: List<User>): ViewState()
    }

    private val compositeDisposable = CompositeDisposable()
    private val _viewState = MutableLiveData<ViewState>()
    val viewState : LiveData<ViewState>
        get() = _viewState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        val disposable = getUsersUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnRequest {
                _viewState.value = ViewState.Loading
            }
            .doOnError {
                _viewState.value = ViewState.Error
            }
            .subscribe {
                _viewState.value = ViewState.Fetched
                _viewState.value = ViewState.Users(it)
            }
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}