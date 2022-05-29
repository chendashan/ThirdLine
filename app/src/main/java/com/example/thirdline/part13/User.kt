package com.example.thirdline.part13

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var firstName: String, var lastName: String, var age: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}