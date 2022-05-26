package com.example.thirdline.part4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityRcvTestBinding
import kotlin.random.Random

class RcvTestActivity : AppCompatActivity() {

    private val list = ArrayList<Fruit>()
    private val list2 = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRcvTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDataList()

        binding.rcvTest.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = RcvTestAdapter(list)
        binding.rcvTest.adapter = adapter

        initDataList2()
        binding.rcvTestPb.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.rcvTestPb.adapter = RcvTestAdapter(list2)
    }


    private fun initDataList() {
        list.apply {

            add(Fruit("Apple", R.drawable.ic_fruit_apple))
            add(Fruit("Banana", R.drawable.ic_fruit_banana))
            add(Fruit("Cherry", R.drawable.ic_fruit_cherry))
            add(Fruit("Grape", R.drawable.ic_fruit_grape))
            add(Fruit("Mango", R.drawable.ic_fruit_mango))
            add(Fruit("Orange", R.drawable.ic_fruit_orange))
            add(Fruit("Pear", R.drawable.ic_fruit_pear))
            add(Fruit("Pineapple", R.drawable.ic_fruit_pineapple))
            add(Fruit("Watermelon", R.drawable.ic_fruit_watermelon))

        }
    }

    private fun initDataList2() {
        list2.apply {
            repeat(3) {
                add(Fruit(getRandomString("Apple"), R.drawable.ic_fruit_apple))
                add(Fruit(getRandomString("Banana"), R.drawable.ic_fruit_banana))
                add(Fruit(getRandomString("Cherry"), R.drawable.ic_fruit_cherry))
                add(Fruit(getRandomString("Grape"), R.drawable.ic_fruit_grape))
                add(Fruit(getRandomString("Mango"), R.drawable.ic_fruit_mango))
                add(Fruit(getRandomString("Orange"), R.drawable.ic_fruit_orange))
                add(Fruit(getRandomString("Pear"), R.drawable.ic_fruit_pear))
                add(Fruit(getRandomString("Pineapple"), R.drawable.ic_fruit_pineapple))
                add(Fruit(getRandomString("Watermelon"), R.drawable.ic_fruit_watermelon))
            }

        }
    }


    private fun getRandomString(str: String):  String{
        val sb = StringBuilder()
        val n = (1..20).random()
        repeat(n) {
            sb.append(str)
        }
        return sb.toString()
    }
}