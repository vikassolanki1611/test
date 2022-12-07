package com.example.roomclass.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Data::class], version=1, exportSchema=false)

abstract class dataBase: RoomDatabase(){
    abstract fun userDao():user_Dao
    companion object {
        @Volatile
        private var INSTANCE: dataBase? = null
        fun getDataBase(context: Context):dataBase{
            val tempInstance= INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext, dataBase::class.java,
                "user_database").build()
                INSTANCE= instance
                return instance
            }

        }
    }
}
