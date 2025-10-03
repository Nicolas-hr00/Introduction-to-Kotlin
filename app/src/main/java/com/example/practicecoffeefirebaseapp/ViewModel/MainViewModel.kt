package com.example.practicecoffeefirebaseapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.practicecoffeefirebaseapp.Domain.BannerModel
import com.example.practicecoffeefirebaseapp.Domain.CategoryModel
import com.example.practicecoffeefirebaseapp.Repository.MainRepository

class MainViewModel : ViewModel () {

    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }
}