package com.example.waifurateapp.data

import com.example.waifurateapp.data.api.WaifuList
import retrofit2.Response

class WaifuRepository {

    suspend fun getImage(): Response<WaifuList>{
        return RetrofitInstance.api.getImage()
    }
}