package com.example.thirdline

import com.example.thirdline.part5.FragmentTestActivity
import com.example.thirdline.part11.RetrofitTestActivity
import com.example.thirdline.part12.MaterialActivity
import com.example.thirdline.part13.JetpackTestActivity
import com.example.thirdline.part13.RoomTestActivity
import com.example.thirdline.part5.DogOneActivity

/**
 * @author chendashan
 * @date 2022/5/27
 */
class PartCollector {

    companion object {

        const val PARAM_NUMBER = "param_number"
        const val PARAM_TITLE = "param_title"

        fun getPartList(index: Int): List<Part> {
            return when (index) {
                5 ->
                    list5
                13 ->
                    list13
                else ->
                    listOf()
            }
        }

        private val list5 = listOf(
            Part(5, "FragmentTest", FragmentTestActivity::class.java),
            Part(5, "Retrofit Test", RetrofitTestActivity::class.java),
            Part(5, "Parcelable序列化", DogOneActivity::class.java)
        )

        private val list13 = listOf(
            Part(13, "ViewModel", JetpackTestActivity::class.java),
            Part(13, "数据库Room框架", RoomTestActivity::class.java)
        )
    }
}