package com.example.androidoffline_onlinedatabase.que_3.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidoffline_onlinedatabase.que_3.Model.Task

@Dao
interface TaskDao {

    @Insert
    fun insertTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY date ASC,time ASC")
    fun getAllTasks():MutableList<Task>

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}