package com.devndroid.meme.api

import com.devndroid.meme.models.MemeList
import retrofit2.Response
import retrofit2.http.GET

interface MemeService {

    @GET("/gimme")
    suspend fun getMeme(): Response<MemeList>
}