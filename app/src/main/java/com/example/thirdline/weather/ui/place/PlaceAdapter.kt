package com.example.thirdline.weather.ui.place

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdline.R
import com.example.thirdline.databinding.ItemWeatherPlaceBinding
import com.example.thirdline.weather.WeatherActivity
import com.example.thirdline.weather.logic.model.Place

/**
 * @author chendashan
 * @date 2022/6/1
 */
class PlaceAdapter(private val fragment: PlaceFragment, private val listPlace: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemWeatherPlaceBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(fragment.context).inflate(R.layout.item_weather_place, parent, false)
        val holder = ViewHolder(view)
        holder.binding.itemPlaceView.setOnClickListener {
            val position = holder.adapterPosition
            val place = listPlace[position]

            val activity = fragment.activity

            if (activity is WeatherActivity) {
                activity.binding.drawerLayout.closeDrawers()
                activity.viewModel.locationLng = place.location.lng
                activity.viewModel.locationLat = place.location.lat
                activity.viewModel.placeName = place.name
                activity.refreshWeather()
            } else {

                val intent = Intent(parent.context, WeatherActivity::class.java).apply {
                    putExtra("location_lng", place.location.lng)
                    putExtra("location_lat", place.location.lat)
                    putExtra("place_name", place.name)
                }


                fragment.startActivity(intent)
                fragment.activity?.finish()
            }
            fragment.viewModel.savePlace(place)
        }
        return holder
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