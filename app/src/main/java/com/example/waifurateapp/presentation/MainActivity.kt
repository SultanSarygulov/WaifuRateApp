package com.example.waifurateapp.presentation

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.waifurateapp.R
import com.example.waifurateapp.data.WaifuRepository
import com.example.waifurateapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater )
        setContentView(binding.root)

        setViewModel()

        mMainViewModel.getImage()
        loadImage()

        binding.leftButton.setOnClickListener {
            loadImage()
        }

        binding.rightButton.setOnClickListener {
            loadImage()
        }

    }

    private fun setViewModel() {
        val repository = WaifuRepository()
        val mainViewModelFactory = ViewModelFactory(repository)
        mMainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
    }

    private fun loadImage() {
        Log.d("Sula", "Loading")
        mMainViewModel.getImage()
        mMainViewModel.myResponse.observe(this,  Observer{waifu ->

            // Create a progressBar drawable
            val circularProgressDrawable = CircularProgressDrawable(this)
            circularProgressDrawable.strokeWidth = 35f
            circularProgressDrawable.centerRadius = 130f
            circularProgressDrawable.start()

            Glide
                .with(binding.root)
                .load(waifu.url)
                .placeholder(circularProgressDrawable)
                .into(binding.image)

            })
    }


}