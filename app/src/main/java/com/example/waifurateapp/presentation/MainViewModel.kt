package com.example.waifurateapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waifurateapp.data.api.Waifu
import com.example.waifurateapp.data.WaifuRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: WaifuRepository): ViewModel() {

    val myResponse: MutableLiveData<Waifu> = MutableLiveData()

    var message: String = ""

    fun getImage(){
        viewModelScope.launch {
            val response = repository.getImage()
            if (response.isSuccessful){
                myResponse.value = response.body()?.images?.get(0)
                message = "Success!"
            } else {
                message = "Something went wrong("
            }
        }
    }

    fun getMes(): String{
        return message
    }
}