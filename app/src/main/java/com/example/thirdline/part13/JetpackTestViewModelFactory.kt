package com.example.thirdline.part13

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class JetpackTestViewModelFactory(private val countReserved: Int) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JetpackTestViewModel(countReserved) as T
    }
}