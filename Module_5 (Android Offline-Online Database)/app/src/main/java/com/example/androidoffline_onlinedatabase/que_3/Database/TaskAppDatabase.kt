package com.example.androidoffline_onlinedatabase.que_3.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidoffline_onlinedatabase.que_3.Dao.TaskDao
import com.example.androidoffline_onlinedatabase.que_3.Model.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskAppDatabase : RoomDatabase() {

    //abstract method
    abstract fun taskDao(): TaskDao

    companion object {
        private var INSTANCE: TaskAppDatabase? = null

        fun getInstance(context: Context): TaskAppDatabase? {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, TaskAppDatabase::class.java, "task_database")
                            .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}