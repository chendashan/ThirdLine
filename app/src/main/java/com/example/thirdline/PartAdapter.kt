package com.example.thirdline

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdline.databinding.ItemPartBinding
import com.example.thirdline.part4.RcvTestAdapter

/**
 * @author chendashan
 * @date 2022/5/27
 */
class PartAdapter(var list: List<Part>) : RecyclerView.Adapter<PartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemPartBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_part, parent, false)
        val holder = ViewHolder(view)

        holder.binding.btItemPart.setOnClickListener {
            val part = list[holder.adapterPosition]
            val intent = Intent(parent.context, part.cls)
            intent.putExtra(PartCollector.PARAM_NUMBER, part.index)
            intent.putExtra(PartCollector.PARAM_TITLE, part.title)
            parent.context.startActivity(intent)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val part = list[position]
        holder.binding.btItemPart.text = part.title
    }

    override fun getItemCount(): Int {
        return list.size
    }
}