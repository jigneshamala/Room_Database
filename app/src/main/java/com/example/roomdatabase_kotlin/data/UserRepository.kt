package com.example.roomdatabase_kotlin.data

import androidx.lifecycle.LiveData
import com.example.roomdatabase_kotlin.fragment.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData:LiveData<List<User>> = userDao.readAllData()

   suspend fun addUser(user: User){
        userDao.addUser(user)
    }

}