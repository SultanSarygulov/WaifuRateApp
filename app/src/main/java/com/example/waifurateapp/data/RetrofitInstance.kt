package com.example.waifurateapp.data

import com.example.waifurateapp.data.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: WaifuApi by lazy {
        retrofit.create(WaifuApi::class.java)
    }
}