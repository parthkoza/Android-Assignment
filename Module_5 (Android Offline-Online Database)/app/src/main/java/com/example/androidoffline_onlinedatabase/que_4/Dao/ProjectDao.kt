package com.example.androidoffline_onlinedatabase.que_4.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidoffline_onlinedatabase.que_4.Model.Project

@Dao
interface ProjectDao {

    @Insert
    fun insertProject(project:Project)

    @Query("Select * From project_table")
    fun getAllProject():MutableList<Project>

    @Delete
    fun deleteProject(project: Project)

    @Update
    fun updateProject(project: Project)
}