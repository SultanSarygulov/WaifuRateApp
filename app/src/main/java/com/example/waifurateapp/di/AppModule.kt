package com.example.waifurateapp.di


import android.content.Context
import android.provider.SyncStateContract
import com.example.waifurateapp.data.WaifuRepositoryImpl
import com.example.waifurateapp.data.api.WaifuApi
import com.example.waifurateapp.domain.WaifuRepository
import com.example.waifurateapp.presentation.MainActivity
import com.example.waifurateapp.presentation.WaifuListener
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWaifuApi(): WaifuApi{
        return Retrofit.Builder()
            .baseUrl("https://api.waifu.im/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WaifuApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWaifuRepository(api: WaifuApi, listener: WaifuListener): WaifuRepository {
        return WaifuRepositoryImpl(api)
    }

//    @Singleton
//    @Provides
//    fun provideListener(activity: MainActivity): WaifuListener {
//        return activity.ListenersImpl()
//    }
}