package com.example.thirdline.part12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.thirdline.R
import com.example.thirdline.databinding.ActivityMaterialBinding
import com.example.thirdline.part4.Fruit
import com.google.android.material.snackbar.Snackbar
import kotlin.concurrent.thread
import kotlin.random.Random

class MaterialActivity : AppCompatActivity() {

    lateinit var binding: ActivityMaterialBinding

    val fruits = mutableListOf(Fruit("Apple", R.drawable.apple), Fruit("Banana", R.drawable.banana),
        Fruit("Orange", R.drawable.orange), Fruit("Watermelon", R.drawable.watermelon), Fruit("Pear", R.drawable.pear),
        Fruit("Grape", R.drawable.grape), Fruit("Pineapple", R.drawable.pineapple), Fruit("Strawberry", R.drawable.strawberry),
        Fruit("Cherry", R.drawable.cherry), Fruit("Mango", R.drawable.mango))

    val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        binding.fab.setOnClickListener {
            Snackbar.make(it, "Data deleted", Snackbar.LENGTH_SHORT).setAction("Undo") {
                Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
            }.show()
        }

        initList()
        val adapter = FruitMdAdapter(this, fruitList)
        binding.rcvMaterial.layoutManager = GridLayoutManager(this, 2)
        binding.rcvMaterial.adapter = adapter

        binding.swipeRefresh.setColorSchemeResources(R.color.green_500)
        binding.swipeRefresh.setOnRefreshListener {
            refreshFruits(adapter)
        }
    }

    private fun initList() {
        fruitList.clear()
        repeat(50) {
            val r = (0 until fruits.size).random()
            fruitList.add(fruits[r])
        }
    }

    private fun refreshFruits(adapter: FruitMdAdapter) {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                initList()
                adapter.notifyDataSetChanged()
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                binding.drawerLayout.openDrawer(GravityCompat.START)
            R.id.backUp ->
                Toast.makeText(this, "Click backUp", Toast.LENGTH_SHORT).show()

            R.id.delete ->
                Toast.makeText(this, "Click delete", Toast.LENGTH_SHORT).show()

            R.id.setting ->
                Toast.makeText(this, "Click setting", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawers()
            return
        }
        super.onBackPressed()
    }
}