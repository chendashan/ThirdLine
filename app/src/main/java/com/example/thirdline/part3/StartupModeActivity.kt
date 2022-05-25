package com.example.thirdline.part3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityStartupModeBinding

class StartupModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LaunchMode", this.toString())
        val binding = ActivityStartupModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btStart.setOnClickListener {
            val intent = Intent(this, StartupModeActivity::class.java)
            startActivity(intent)
        }

        binding.btStartFirst.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }
    }
}