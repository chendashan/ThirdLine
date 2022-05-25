package com.example.thirdline.part3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivitySecondBinding

class SecondActivity : BaseThreeActivity() {

    companion object {
        fun actionStart(context: Context, data1: String, data2: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("data_1", data1)
            intent.putExtra("data_2", data2)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val string = intent.getStringExtra("param_data")
        Log.d("SecondActivity", "data : $string")

        val data1 = intent.getStringExtra("data_1")
        val data2 = intent.getStringExtra("data_2")
        Log.d("SecondActivity", "data1 is $data1 , data2 is $data2")

        binding.btSecond1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("param_data", "this is return data")
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btExitApp.setOnClickListener {
            ActivityCollector.finishAll()
        }
    }
}