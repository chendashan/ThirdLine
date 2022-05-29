package com.example.thirdline.part5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityDogOneBinding

class DogOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = this.localClassName

        val dog = DogData(3, "旺财", "阿拉斯加")

        val list = listOf(DogData(1, "旺财", "阿拉斯加"), DogData(2, "park", "中华田园犬"),
                DogData(3, "邓肯", "柴犬"), DogData(4, "擎天柱", "藏獒"))

        val dogList = ArrayList<DogData>()
        dogList.addAll(list)

        binding.btOneEnter.setOnClickListener {
            val intent = Intent(this, DogTwoActivity::class.java)
            intent.putExtra("param_list", dogList)
            startActivity(intent)
        }
    }
}