package com.example.practicecoffeefirebaseapp.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.practicecoffeefirebaseapp.Adapter.CategoryAdapter
import com.example.practicecoffeefirebaseapp.R
import com.example.practicecoffeefirebaseapp.ViewModel.MainViewModel
import com.example.practicecoffeefirebaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
        initCategory()

    }

    private fun initCategory() {
        binding.progressBarCategory.visibility=View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.recyclerViewPopular.layoutManager= LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL, false
            )
            binding.recyclerViewPopular.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility= View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initBanner() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility = View.GONE
        }
        viewModel.loadBanner()
    }


}