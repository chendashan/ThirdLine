package com.example.thirdline.weather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.thirdline.weather.logic.Repository
import com.example.thirdline.weather.logic.model.Place

/**
 * @author chendashan
 * @date 2022/6/1
 */
class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlace(query: String) {
        searchLiveData.value = query
    }
}