package com.example.thirdline

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thirdline.databinding.ActivityMainBinding
import com.example.thirdline.part12.MaterialActivity
import com.example.thirdline.part13.JetpackTestActivity
import com.example.thirdline.part3.BaseThreeActivity
import com.example.thirdline.part3.FirstActivity
import com.example.thirdline.part4.UiTestActivity
import com.example.thirdline.weather.WeatherActivity

class MainActivity : BaseThreeActivity() {

    private val list = ArrayList<Part>()

    private lateinit var partAdapter: PartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //加载布局
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //Binding类的getRoot()函数可以得到activity_main.xml中根元素的实例
        setContentView(binding.root)

        supportActionBar?.title = "MainActivity"

        binding.btMain.setOnClickListener {
            Toast.makeText(this, "click main button", Toast.LENGTH_SHORT).show()

            // SecondActivity::class.java 相当于Java中 SecondActivity.class
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        Log.d("MainActivity", "onCreate() execute")


        initPart()
        partAdapter = PartAdapter(list)
        binding.rcvMainPart.layoutManager = LinearLayoutManager(this)
        binding.rcvMainPart.adapter = partAdapter

    }

    /**
     * 返回值表示菜单是否显示
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item ->
                Toast.makeText(this, "add item", Toast.LENGTH_SHORT).show()
            R.id.remove_item ->
                Toast.makeText(this, "remove item", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initPart() {
        list.apply {
            add(Part(4, "Part Four", UiTestActivity::class.java))
            add(Part(5, "第5章 Fragment", PartListActivity::class.java))
            add(Part(12, "第12章 Material Design", MaterialActivity::class.java))
            add(Part(13, "第13章 Jetpack", PartListActivity::class.java))
            add(Part(15, "第15章 天气App", WeatherActivity::class.java))
        }
    }
}