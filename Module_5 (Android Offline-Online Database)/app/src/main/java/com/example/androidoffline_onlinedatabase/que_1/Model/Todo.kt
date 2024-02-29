package com.example.androidoffline_onlinedatabase.que_1.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0 ,
    var title:String,
    var date : String,
    var desc : String,
    var createdAt : Long = System.currentTimeMillis(),
    var isCompleted :Boolean = true
):Parcelable
