package com.example.roomclass.data

import androidx.lifecycle.LiveData
import com.testapplication.ui.main.dataClass.testDataItem

class userRepo (private val userDao: user_Dao){
  val readaAllData:LiveData<List<Data>> = userDao.readalldata()
   fun adduser(data:Data){
    userDao.addData(data)
  }
    fun insertallData(data: List<Data>){
        userDao.insertAll(data)
    }
}