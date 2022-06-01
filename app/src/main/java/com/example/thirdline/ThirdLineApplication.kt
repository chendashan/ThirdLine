package com.example.thirdline

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author chendashan
 * @date 2022/5/31
 */
class ThirdLineApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        const val WEATHER_TOKEN = "KmvZYsK4UNYzGf6w"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}