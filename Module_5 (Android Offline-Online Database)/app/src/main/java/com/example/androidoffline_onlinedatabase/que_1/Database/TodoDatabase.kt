package com.example.androidoffline_onlinedatabase.que_1.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidoffline_onlinedatabase.que_1.Dao.TodoDao
import com.example.androidoffline_onlinedatabase.que_1.Model.Todo


@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase:RoomDatabase() {

    abstract fun todoDao():TodoDao
    companion object{
        private var INSTANCE : TodoDatabase?=null

        fun getInstance(context: Context):TodoDatabase?{
            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,TodoDatabase::class.java,"To do").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}