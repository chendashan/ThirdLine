package com.example.thirdline.part12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thirdline.R
import com.example.thirdline.databinding.ItemFruitMdBinding
import com.example.thirdline.part4.Fruit

class FruitMdAdapter(val context: Context, val list: List<Fruit>) : RecyclerView.Adapter<FruitMdAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemFruitMdBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_fruit_md, parent, false)
        val holder = ViewHolder(view)
        holder.binding.ivMdFruit.setOnClickListener {
            val fruit = list[holder.adapterPosition]
            FruitDetailActivity.actionStart(context, fruit.name, fruit.imgId)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = list[position]
        holder.binding.tvMdFruit.text = fruit.name
        Glide.with(context).load(fruit.imgId).into(holder.binding.ivMdFruit)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}