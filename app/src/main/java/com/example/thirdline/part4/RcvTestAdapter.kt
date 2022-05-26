package com.example.thirdline.part4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdline.R
import com.example.thirdline.databinding.ItemRcvTestBinding

class RcvTestAdapter(private val list: List<Fruit>): RecyclerView.Adapter<RcvTestAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemRcvTestBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rcv_test, parent, false)
        val holder = ViewHolder(view)

        holder.binding.ivRcvFruit.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = list[position]
            Toast.makeText(parent.context, "Click ${fruit.name} image", Toast.LENGTH_SHORT).show()
        }
        holder.binding.tvRcvContent.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = list[position]
            Toast.makeText(parent.context, "Click ${fruit.name} text", Toast.LENGTH_SHORT).show()
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = list[position]
        holder.binding.ivRcvFruit.setImageResource(fruit.imgId)
        holder.binding.tvRcvContent.text = fruit.name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}