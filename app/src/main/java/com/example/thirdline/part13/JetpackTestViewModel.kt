package com.example.thirdline.part13

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JetpackTestViewModel(countReserved: Int) : ViewModel() {

    // LiveData 声明为不可变的
    val counter: LiveData<Int>
        get() = _counter

    // MutableLiveData 声明为可变的
    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }
}