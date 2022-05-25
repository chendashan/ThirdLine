package com.example.thirdline.part3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private val launcherActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        when (it.resultCode) {
            RESULT_OK -> {
                val str = it.data?.getStringExtra("param_data")
                Log.d("FirstActivity", "result:  $str")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btResultStart.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            launcherActivity.launch(intent)
        }

        binding.btFirst1.setOnClickListener {
            // SecondActivity::class.java 相当于Java中 SecondActivity.class
            val intent1 = Intent(this, SecondActivity::class.java)
            val intent2 = Intent("com.example.thirdline.START_ACTION")
            intent2.addCategory("com.example.thirdline.MY_CATEGORY")

            intent2.putExtra("param_data", "this is data")

            startActivity(intent2)
        }
    }
}