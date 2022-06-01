package com.example.thirdline.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityWeatherBinding
import com.example.thirdline.weather.logic.model.Place
import com.example.thirdline.weather.logic.network.WeatherNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val job = Job()
//        val scope = CoroutineScope(job)
//        scope.launch {
//            val response = WeatherNetwork.searchPlaces("北京")
//            Log.d("WeatherActivity", response.places.toString())
//        }

    }

    override fun onDestroy() {
        super.onDestroy()

    }

}