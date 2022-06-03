package com.example.thirdline.weather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.thirdline.weather.logic.Repository
import com.example.thirdline.weather.logic.model.Place

/**
 * @author chendashan
 * @date 2022/6/1
 *
 * ViewModel相当于逻辑层和UI层之间的一个桥梁
 *
 * LiveData在数据发生变化的时候通知给观察者，用数据驱动的思想替换了常规接口回调的方式。
 */
class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    //switchMap()方法，将传入的不可观察的LiveData对象转换成另外一个可观察的LiveData对象
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlace(query: String) {
        //改变了searchLiveData的值，就相当于执行了Repository里liveData()的代码块
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavePlace() = Repository.getSavePlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}