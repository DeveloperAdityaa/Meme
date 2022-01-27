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

        loadMeme()
        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            loadMeme()
        }

    }

    private fun loadMeme() {
        val memeService = RetrofitHelper.getInstance().create(MemeService::class.java)
        val repository = MemeRepository(memeService)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))
            .get(MainViewModel::class.java)

        mainViewModel.loadMeme()
        val imgMeme = findViewById<ImageView>(R.id.imgMeme)
        mainViewModel.memes.observe(this, Observer {

            Glide
                .with(this)
                .load(it.url)
                .fitCenter()
                .into(imgMeme)
        })
    }
}