package com.example.waifurateapp.data

import retrofit2.Response
import retrofit2.http.GET

interface WaifuApi {

    @GET("search/?included_tags=ass")
    suspend fun getImage(): Response<WaifuList>
}