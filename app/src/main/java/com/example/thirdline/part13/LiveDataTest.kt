package com.example.thirdline.part13

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel


class MainViewModel(): ViewModel() {

    private val userLiveData = MutableLiveData<String>()

    val user: LiveData<User> = Transformations.switchMap(userLiveData) { userId ->
        Repository.getUser(userId)
    }

    fun getUser(userId: String) {
        userLiveData.value = userId
    }


//    val userName: LiveData<String> = Transformations.map(userLiveData) { user ->
//        "${user.firstName}  ${user.lastName}"
//    }
}


object Repository {
    fun getUser(userId: String): LiveData<User> {
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId, userId, 0)
        return  liveData
    }
}