package com.example.thirdline.part4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.thirdline.databinding.ItemLvTestBinding

class LvTestAdapter(context: Context, private val resId: Int, data: List<Fruit>) : ArrayAdapter<Fruit>(context, resId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val binding: ItemLvTestBinding
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resId, parent, false)
            binding = ItemLvTestBinding.bind(view)
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ItemLvTestBinding
        }

        val fruit = getItem(position)
        fruit?.let {
            binding.tvItemName.text = it.name
            binding.ivLvTest.setImageResource(it.imgId)
        }

        return view
    }

}