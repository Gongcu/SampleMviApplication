package com.example.presentation.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.domain.model.User
import com.example.presentation.R
import com.example.presentation.databinding.ActivityUsersBinding
import com.example.presentation.di.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class UsersActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: UsersViewModel
    private lateinit var binding: ActivityUsersBinding
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[UsersViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        adapter = UsersAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.viewState.observe(this) {
            render(it)
        }
    }

    private fun render(viewState: UsersViewModel.ViewState) {
        when(viewState){
            is UsersViewModel.ViewState.Error ->  renderErrorView()
            is UsersViewModel.ViewState.Loading ->  renderLoadingView()
            is UsersViewModel.ViewState.Fetched ->  renderFetchedView()
            is UsersViewModel.ViewState.Users ->  renderUsersView(viewState.users)
        }
    }

    private fun renderErrorView() {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(
            this,
            "Network Error",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun renderLoadingView() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun renderFetchedView() {
        binding.progressBar.visibility = View.GONE
    }

    private fun renderUsersView(users: List<User>) {
        adapter.submitList(users)
    }
}