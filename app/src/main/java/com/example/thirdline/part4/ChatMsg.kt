package com.example.thirdline.part4

/**
 * @author chendashan
 * @date 2022/5/27
 */
class ChatMsg(val type: Int, val content: String) {
    companion object {
        const val TYPE_SEND = 0
        const val TYPE_RECEIVE = 1
    }
}