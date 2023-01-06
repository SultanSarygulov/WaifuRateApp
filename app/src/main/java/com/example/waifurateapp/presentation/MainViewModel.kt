package com.example.waifurateapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.waifurateapp.data.Waifu
import com.example.waifurateapp.data.WaifuRepository

class MainViewModel(private val repository: WaifuRepository): ViewModel() {

    val myResponse: MutableLiveData<List<Waifu>> = MutableLiveData()

    fun getImage(){

    }
}