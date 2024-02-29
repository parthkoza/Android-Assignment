package com.example.androidoffline_onlinedatabase.que_4.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidoffline_onlinedatabase.que_4.Dao.ProjectDao
import com.example.androidoffline_onlinedatabase.que_4.Model.Project

@Database(entities = [Project::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //Abstract class
    abstract fun projectDao(): ProjectDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "Project")
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}