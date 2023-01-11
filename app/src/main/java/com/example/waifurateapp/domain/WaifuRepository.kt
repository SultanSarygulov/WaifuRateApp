package com.example.waifurateapp.domain

import com.example.waifurateapp.data.api.WaifuList
import retrofit2.Response

interface WaifuRepository {
    suspend fun getImage(): Response<WaifuList>
}