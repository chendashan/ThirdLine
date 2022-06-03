package com.example.thirdline.weather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.example.thirdline.ThirdLineApplication
import com.example.thirdline.weather.logic.model.Place
import com.google.gson.Gson

object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavePlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() = ThirdLineApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}