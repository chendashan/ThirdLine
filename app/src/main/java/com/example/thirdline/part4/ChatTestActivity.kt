package com.example.thirdline.part4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thirdline.databinding.ActivityChatTestBinding

class ChatTestActivity : AppCompatActivity() {
    private var list = ArrayList<ChatMsg>()

    private lateinit var adapter: ChatMsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDataList()
        if (!::adapter.isInitialized) {
            adapter = ChatMsgAdapter(list)
        }
        binding.rcvChatMessage.layoutManager = LinearLayoutManager(this)
        binding.rcvChatMessage.adapter = adapter

        binding.btSendMessage.setOnClickListener {
            val content = binding.etMessageContent.text.toString()
            if (content.isNotEmpty()) {
                list.add(ChatMsg(0, content))
                adapter.notifyItemChanged(list.size - 1)
                binding.rcvChatMessage.scrollToPosition(list.size - 1)
                binding.etMessageContent.setText("")
            }
        }
    }

    private fun initDataList() {
        list.apply {
            add(ChatMsg(1, "你好啊"))
            add(ChatMsg(0, "敕勒川阴山下天似穹庐笼盖四野天苍苍野茫茫"))
            add(ChatMsg(1, "风吹草低现牛羊"))
        }

    }
}