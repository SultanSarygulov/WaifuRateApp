package com.example.waifurateapp.data


import com.example.waifurateapp.data.api.WaifuApi
import com.example.waifurateapp.data.api.WaifuList
import com.example.waifurateapp.domain.WaifuRepository
import retrofit2.Response
import javax.inject.Inject

class WaifuRepositoryImpl
@Inject
constructor(private val api: WaifuApi): WaifuRepository {

    override suspend fun getImage(): Response<WaifuList>{
        return api.getImage()
    }
}