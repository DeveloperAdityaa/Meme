package com.devndroid.meme.api

import com.devndroid.meme.models.MemeList
import retrofit2.Response
import retrofit2.http.GET

interface MemeService {

    /* defining the end point of api link
    this getMeme function will return the memeList to repository
     */
    @GET("/gimme")
    suspend fun getMeme(): Response<MemeList>
}