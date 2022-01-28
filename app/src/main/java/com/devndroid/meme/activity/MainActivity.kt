package com.devndroid.meme.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.devndroid.meme.R
import com.devndroid.meme.api.MemeService
import com.devndroid.meme.api.RetrofitHelper
import com.devndroid.meme.repository.MemeRepository
import com.devndroid.meme.viewmodels.MainViewModel
import com.devndroid.meme.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load the meme on onCreate
        loadMeme()
        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            //load the meme on next button click
            loadMeme()
        }

    }

    //function defination
    private fun loadMeme() {

        //creation of memeService object using retrofit helper
        val memeService = RetrofitHelper.getInstance().create(MemeService::class.java)
        //cration of repository
        val repository = MemeRepository(memeService)

        /* we need repository for creating viewModel object */

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))
            .get(MainViewModel::class.java)

        //calling viewmodel's loadMeme function
        mainViewModel.loadMeme()
        val imgMeme = findViewById<ImageView>(R.id.imgMeme)

        //accessing memes livedata of viewmodel
        mainViewModel.memes.observe(this, Observer {

            //this is a external library for image loading
            //its dependency is added in gradle
            Glide
                .with(this)
                .load(it.url)
                .fitCenter()
                .into(imgMeme)
        })
    }
}