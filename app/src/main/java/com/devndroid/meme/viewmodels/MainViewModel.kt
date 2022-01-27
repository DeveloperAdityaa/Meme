package com.devndroid.meme.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devndroid.meme.models.MemeList
import com.devndroid.meme.repository.MemeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MemeRepository) : ViewModel() {


    fun loadMeme(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMeme()
        }
    }

    val memes: LiveData<MemeList>
        get() = repository.memes
}
