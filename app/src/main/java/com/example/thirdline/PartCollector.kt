package com.example.thirdline

import com.example.thirdline.part5.FragmentTestActivity

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
                else ->
                    listOf()
            }
        }

        private val list5 = listOf(
            Part(5, "FragmentTest", FragmentTestActivity::class.java)

        )
    }
}