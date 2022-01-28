package com.devndroid.meme.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devndroid.meme.models.MemeList
import com.devndroid.meme.repository.MemeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MemeRepository) : ViewModel() {


    /* this function will call for loading the meme and it will call the repository's
    getMeme method which will load the meme again (new memea all the time) because
    it hits api again
     */
    fun loadMeme(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMeme()
        }
    }

    // just storing the data which is gettin in repository
    val memes: LiveData<MemeList>
        get() = repository.memes
}
