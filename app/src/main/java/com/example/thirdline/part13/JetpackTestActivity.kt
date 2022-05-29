package com.example.thirdline.part13

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityJetpackTestBinding
import kotlin.concurrent.thread

class JetpackTestActivity : AppCompatActivity() {

    lateinit var binding: ActivityJetpackTestBinding

    lateinit var viewModel: JetpackTestViewModel

    lateinit var mainViewModel: MainViewModel

    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJetpackTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(MyObserver(lifecycle))

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)


        //计数器ViewModel相关
        viewModel = ViewModelProvider(this, JetpackTestViewModelFactory(countReserved)).get(JetpackTestViewModel::class.java)

        //viewModel = ViewModelProvider(this).get(JetpackTestViewModel::class.java)

        binding.btJtPlus.setOnClickListener {
            viewModel.plusOne()
        }

        binding.btJtClear.setOnClickListener {
            viewModel.clear()
        }
        viewModel.counter.observe(this) { count ->
            binding.tvJtText.text = count.toString()
        }


        // switchMap()相关
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btGetUser.setOnClickListener {
            val userId = (0..1000).random().toString()
            mainViewModel.getUser(userId)
        }
        mainViewModel.user.observe(this, Observer {
            binding.tvJtText.text = it.firstName
        })




        //refreshCounter()
    }

    private fun refreshCounter() {
        binding.tvJtText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }
}