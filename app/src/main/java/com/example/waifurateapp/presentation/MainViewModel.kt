package com.example.waifurateapp.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waifurateapp.data.WaifuRepositoryImpl
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val repository: WaifuRepositoryImpl/*, private val listener: WaifuListener*/): ViewModel() {

    val myResponse: MutableLiveData<String> = MutableLiveData()

    fun getImage(){
        viewModelScope.launch {
            try{
                Log.d("Sula", "MainViewModel getImage")
                val response = repository.getImage()
                myResponse.value = response.body()?.images?.get(0)?.url

//                listener.changeColor()

            } catch (e: HttpException) {

                Log.d("Sula", "getImage HttpException: $e")
            } catch (e: Throwable) {

//                listener.loadErrorImage()
            }

        }
    }
}