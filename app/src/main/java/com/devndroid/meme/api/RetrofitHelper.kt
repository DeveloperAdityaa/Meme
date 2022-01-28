package com.devndroid.meme.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    /*
    we are adding the base url of the api and returning the retrofit object
    the getInstance method will return the MemeService object, we can't creare memeService object
    without this method
     */
    private val BASE_URL = "https://meme-api.herokuapp.com/"

    fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}