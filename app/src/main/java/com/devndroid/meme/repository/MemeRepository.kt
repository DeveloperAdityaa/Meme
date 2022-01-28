package com.devndroid.meme.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devndroid.meme.api.MemeService
import com.devndroid.meme.models.MemeList

class MemeRepository(private val memeService: MemeService) {

    /* we are creating two live datas because we don't want to show my mutable livedata
    to any class but we need mutable live data so we can't use only non mutable live data
    we can do it only with mutable live data, if security is not concern
     */
    private val memeLiveData = MutableLiveData<MemeList>()

    val memes : LiveData<MemeList>
        get() = memeLiveData

    /*
    It will call memeService method to getting data from api,
    and store it to live data
     */
    suspend fun getMeme(){
        val result = memeService.getMeme()

        //it is checking that result != null && result.body() != null
        if(result?.body() != null){
            memeLiveData.postValue(result.body())
        }
    }


}