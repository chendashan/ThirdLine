package com.example.thirdline.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivitySearchPlacesBinding

class SearchPlacesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchPlacesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}