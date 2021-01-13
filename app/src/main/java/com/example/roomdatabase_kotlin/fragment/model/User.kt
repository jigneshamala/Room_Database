package com.example.roomdatabase_kotlin.fragment.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int
)