package com.example.thirdline.part5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityFragmentTestBinding

class FragmentTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = AnotherFragment()

        val manager = supportFragmentManager
        val beginTran = manager.beginTransaction()
        beginTran.replace(R.id.fl_fragment_test, fragment)
        beginTran.commit()
    }
}