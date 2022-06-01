package com.example.thirdline.weather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdline.R
import com.example.thirdline.databinding.ItemWeatherPlaceBinding
import com.example.thirdline.weather.logic.model.Place

/**
 * @author chendashan
 * @date 2022/6/1
 */
class PlaceAdapter(private val fragment: Fragment, private val listPlace: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemWeatherPlaceBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(fragment.context).inflate(R.layout.item_weather_place, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = listPlace[position]
        holder.binding.placeAddress.text = place.address
        holder.binding.placeName.text = place.name
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }
}