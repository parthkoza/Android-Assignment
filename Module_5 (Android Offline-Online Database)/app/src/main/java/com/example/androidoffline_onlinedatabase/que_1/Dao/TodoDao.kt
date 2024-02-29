package com.example.androidoffline_onlinedatabase.que_1.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidoffline_onlinedatabase.que_1.Model.Todo

@Dao
interface TodoDao {

    @Insert
    fun insertTodoTask(todo: Todo)

    @Query(" Select * From todo_table ")
    fun getAllTasks():MutableList<Todo>

    @Query(" Select * From todo_table ORDER BY date desc")
    fun getCompletedTasks():MutableList<Todo>
    @Query(" Select * From todo_table ORDER BY date ASC")
    fun getUpcomingTasks():MutableList<Todo>

    @Delete
    fun deleteTask(todo: Todo)

    @Update
    fun updateTask(todo: Todo)

}