package com.example.thirdline.part4

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.thirdline.R
import com.example.thirdline.databinding.LayoutCustomTitleBinding

/**
 * @author chendashan
 * @date 2022/5/26
 */
class CustomTitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_custom_title, this)
        val binding = LayoutCustomTitleBinding.bind(view)

        binding.tvTitleContent.text = "自定义控件标题"
        binding.btTitleBack.setOnClickListener {
            Toast.makeText(context, "自定义控件返回", Toast.LENGTH_SHORT).show()
            val activity  = context as Activity
            activity.finish()
        }
        binding.btTitleEdit.setOnClickListener {
            Toast.makeText(context, "自定义控件编辑", Toast.LENGTH_SHORT).show()
        }
    }
}