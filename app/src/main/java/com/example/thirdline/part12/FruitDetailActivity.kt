package com.example.thirdline.part12

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityFruitDetailBinding

class FruitDetailActivity : AppCompatActivity() {

    companion object {
        private const val PARAM_NAME = "param_name"
        private const val PARAM_IDS = "param_ids"

        fun actionStart(context: Context, name: String, ids: Int) {
            val intent = Intent(context, FruitDetailActivity::class.java)
            intent.putExtra(PARAM_NAME, name)
            intent.putExtra(PARAM_IDS, ids)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFruitDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(PARAM_NAME)
        val imgId = intent.getIntExtra(PARAM_IDS, R.drawable.watermelon)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.collapsingToolbar.title = name



        binding.tvFruitContent.text = getFruitContent(name?:"")
        Glide.with(this).load(imgId).into(binding.ivToolbarFruit)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getFruitContent(name: String) = name.repeat(500)
}