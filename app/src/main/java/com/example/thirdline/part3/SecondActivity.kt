package com.example.thirdline.part3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val string = intent.getStringExtra("param_data")
        Log.d("SecondActivity", "data : $string")

        binding.btSecond1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("param_data", "this is return data")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}