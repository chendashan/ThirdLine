package com.example.thirdline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.thirdline.databinding.ActivityMainBinding
import com.example.thirdline.part3.BaseThreeActivity
import com.example.thirdline.part3.FirstActivity

class MainActivity : BaseThreeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //加载布局
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //Binding类的getRoot()函数可以得到activity_main.xml中根元素的实例
        setContentView(binding.root)

        binding.btMain.setOnClickListener {
            Toast.makeText(this, "click main button", Toast.LENGTH_SHORT).show()

            // SecondActivity::class.java 相当于Java中 SecondActivity.class
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        Log.d("MainActivity", "onCreate() execute")
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
}