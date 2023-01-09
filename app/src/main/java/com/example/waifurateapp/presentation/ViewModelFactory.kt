package com.example.waifurateapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.waifurateapp.data.WaifuRepository

class ViewModelFactory(private val repository: WaifuRepository, private  val listener: Listener): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, listener) as T
    }

}