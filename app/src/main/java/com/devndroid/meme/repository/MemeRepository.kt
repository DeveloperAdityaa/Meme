package com.devndroid.meme.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devndroid.meme.api.MemeService
import com.devndroid.meme.models.MemeList

class MemeRepository(private val memeService: MemeService) {

    private val memeLiveData = MutableLiveData<MemeList>()

    val memes : LiveData<MemeList>
        get() = memeLiveData

    suspend fun getMeme(){
        val result = memeService.getMeme()

        if(result?.body() != null){
            memeLiveData.postValue(result.body())
        }
    }


}