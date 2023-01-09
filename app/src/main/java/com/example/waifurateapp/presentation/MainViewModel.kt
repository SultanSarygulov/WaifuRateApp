package com.example.waifurateapp.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waifurateapp.data.api.Waifu
import com.example.waifurateapp.data.WaifuRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(private val repository: WaifuRepository, private val listener: Listener): ViewModel() {

    val myResponse: MutableLiveData<String> = MutableLiveData()

    fun getImage(){
        viewModelScope.launch {
            try{
                Log.d("Sula", "MainViewModel getImage")
                val response = repository.getImage()
                myResponse.value = response.body()?.images?.get(0)?.url

                listener.changeColor()

            } catch (e: HttpException) {

                Log.d("Sula", "getImage HttpException: $e")
            } catch (e: Throwable) {

                listener.loadErrorImage()
            }

        }
    }
}