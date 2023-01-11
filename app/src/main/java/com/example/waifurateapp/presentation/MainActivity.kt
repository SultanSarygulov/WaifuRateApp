package com.example.waifurateapp.presentation

import android.location.GnssAntennaInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.waifurateapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater )
        setContentView(binding.root)

        setViewModel()

        loadImage()

        binding.leftButton.setOnClickListener {
            mMainViewModel.getImage()
            Log.d("Sula", "leftButton")
            loadImage()
        }

        binding.rightButton.setOnClickListener {
            mMainViewModel.getImage()
            Log.d("Sula", "rightButton")
            loadImage()
        }

    }

    private fun setViewModel() {
//        val repository = WaifuRepositoryImpl()

    }

    private fun loadImage() {
        Log.d("Sula", "Loading")
        mMainViewModel.myResponse.observe(this,  Observer{waifu ->

            // Create a progressBar drawable
            val circularProgressDrawable = CircularProgressDrawable(this)
            circularProgressDrawable.strokeWidth = 35f
            circularProgressDrawable.centerRadius = 130f
            circularProgressDrawable.start()

            Log.d("Sula", "loadImage: ${waifu}")

            Glide
                .with(binding.root)
                .load(waifu)
                .placeholder(circularProgressDrawable)
                .into(binding.image)

            })
    }


    inner class ListenersImpl(): WaifuListener{
        override fun changeColor() {
            binding.noWifiImage.isGone = true
        }

        override fun loadErrorImage() {
            binding.noWifiImage.isVisible = true
        }
    }


}