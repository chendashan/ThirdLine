package com.example.thirdline.part5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityDogTwoBinding

class DogTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = this.localClassName
        var content = ""
        val dog = intent.getParcelableExtra<DogData>("param_dog")

        val dogList = intent.getParcelableArrayListExtra<DogData>("param_list")


        if (dog != null) {
            content = "dog的序号为 ${dog.number}  名字： ${dog.name},  品种是 ${dog.type}"
        } else if (dogList != null) {
            val sb = StringBuilder()
            for (d in dogList) {
                sb.append("dog的序号为 ").append(d.number).append("  名字：  ").append(d.name).append(", 品种是 ").append(d.type).append("\n")
            }
            content = sb.toString()
        }

        binding.tvTwoText.text = content
    }
}