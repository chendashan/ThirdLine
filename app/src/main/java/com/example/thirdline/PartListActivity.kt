package com.example.thirdline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thirdline.databinding.ActivityPartListBinding

class PartListActivity : AppCompatActivity() {

    private var number: Int = 0
    private lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPartListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        number = intent.getIntExtra(PartCollector.PARAM_NUMBER, 0)
        title = intent.getStringExtra(PartCollector.PARAM_TITLE)?:""

        val list = PartCollector.getPartList(number)
        val adapter = PartAdapter(list)
        binding.rcvPartList.layoutManager = LinearLayoutManager(this)
        binding.rcvPartList.adapter = adapter
    }
}