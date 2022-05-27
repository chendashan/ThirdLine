package com.example.thirdline.part4

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdline.databinding.ItemMessageLeftBinding
import com.example.thirdline.databinding.ItemMessageRightBinding

/**
 * @author chendashan
 * @date 2022/5/27
 */

sealed class MsgViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class LeftViewHolder(itemView: View) : MsgViewHolder(itemView) {
    val binding = ItemMessageLeftBinding.bind(itemView)
}

class RightViewHolder(itemView: View) : MsgViewHolder(itemView) {
    val binding = ItemMessageRightBinding.bind(itemView)
}
