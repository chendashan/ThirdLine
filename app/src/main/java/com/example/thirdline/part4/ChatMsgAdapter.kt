package com.example.thirdline.part4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdline.R

/**
 * @author chendashan
 * @date 2022/5/27
 */
class ChatMsgAdapter(private val list: List<ChatMsg>) : RecyclerView.Adapter<MsgViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        return if (viewType == ChatMsg.TYPE_RECEIVE) {
            val viewLeft = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_left, parent, false)
            LeftViewHolder(viewLeft)
        } else {
            val viewRight = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_right, parent, false)
            RightViewHolder(viewRight)
        }
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val message = list[position]

        when (holder) {
            is LeftViewHolder ->
                holder.binding.tvMessageLeft.text = message.content
            is RightViewHolder ->
                holder.binding.tvMessageRight.text = message.content
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }
}