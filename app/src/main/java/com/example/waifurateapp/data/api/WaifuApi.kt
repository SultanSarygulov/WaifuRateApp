package com.example.waifurateapp.data.api

import retrofit2.Response
import retrofit2.http.GET

interface WaifuApi {

    @GET("https://api.waifu.im/search/")
    suspend fun getImage(): Response<WaifuList>
}