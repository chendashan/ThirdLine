package com.example.thirdline.part4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityLvTestBinding

class LvTestActivity : AppCompatActivity() {

    private val list = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLvTestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = LvTestAdapter(this, R.layout.item_lv_test, initDataList())
        binding.lvTest.adapter = adapter

        binding.lvTest.setOnItemClickListener { _, _, i, _ ->
            val fruit = list[i]
            Toast.makeText(this, "click ${fruit.name}", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initDataList(): List<Fruit> {
        list.apply {
            repeat(2) {
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

        return list
    }
}