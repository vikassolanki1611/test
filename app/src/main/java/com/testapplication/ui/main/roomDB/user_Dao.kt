package com.example.roomclass.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.testapplication.ui.main.dataClass.testDataItem

@Dao
interface user_Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addData(data: Data)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(testdata:List<Data>)

    @Query("SELECT*FROM `User Info` ORDER BY id ASC")
    fun readalldata():LiveData<List<Data>>
}