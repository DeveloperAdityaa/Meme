package com.devndroid.meme.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devndroid.meme.repository.MemeRepository

//it is just a simple class which just crate a paramitarize viewModel
class MainViewModelFactory(private val repository: MemeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}