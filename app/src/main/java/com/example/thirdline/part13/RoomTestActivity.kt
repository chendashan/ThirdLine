package com.example.thirdline.part13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityRoomTestBinding
import kotlin.concurrent.thread

class RoomTestActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomTestBinding

    private var sbText = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //数据库操作Room相关
        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)
        binding.btAddData.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        binding.btUpdateData.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        binding.btDeleteData.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }
        binding.btQueryData.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    val result = user.toString()
                    Log.d("RoomTestActivity", result)

                    sbText.append(result).append("\n")
                }
                sbText.append("\n")
                runOnUiThread{
                    binding.tvRoomText.text = sbText
                    binding.svRoomContent.fullScroll(ScrollView.FOCUS_DOWN)
                }
            }
        }

    }
}