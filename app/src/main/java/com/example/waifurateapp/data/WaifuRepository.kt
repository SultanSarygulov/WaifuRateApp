package com.example.waifurateapp.data

import retrofit2.Response
import retrofit2.Retrofit

class WaifuRepository {

    suspend fun getImage(): Response<WaifuList>{
        return RetrofitInstance.api.getImage()
    }
}