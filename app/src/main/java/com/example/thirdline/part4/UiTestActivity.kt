package com.example.thirdline.part4

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityUiTestBinding

class UiTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUiTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btOpenDialog.setOnClickListener {
            showDialog()
        }

        binding.includeTitle.tvTitleContent.text = "引入布局的标题"
        binding.includeTitle.btTitleBack.setOnClickListener {
            finish()
        }
        binding.includeTitle.btTitleEdit.setOnClickListener {
            Toast.makeText(this, "Click Edit", Toast.LENGTH_SHORT).show()
        }

        binding.btLvTest.setOnClickListener {
            startActivity(Intent(this, LvTestActivity::class.java))
        }

        binding.btRcvTest.setOnClickListener {
            startActivity(Intent(this, RcvTestActivity::class.java))
        }
    }

    private fun showDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("This is Dialog")
            setMessage("这是弹窗的内容，我的靴子里有条蛇")
            setPositiveButton("OK") {
                    dialog, _ ->
                Toast.makeText(context, "点击了OK", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
            setNegativeButton("取消") {
                    dialog, _ ->
                dialog.cancel()
            }
            show()
        }
    }
}