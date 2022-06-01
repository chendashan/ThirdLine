package com.example.thirdline.weather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @author chendashan
 * @date 2022/6/1
 */

data class PlaceResponse (val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location, @SerializedName("formatted_address")val address: String)

data class Location(val lng: String, val lat: String)