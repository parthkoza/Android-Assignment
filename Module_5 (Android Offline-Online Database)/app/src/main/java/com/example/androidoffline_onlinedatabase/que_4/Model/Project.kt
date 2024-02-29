package com.example.androidoffline_onlinedatabase.que_4.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "project_table")
@Parcelize
data class Project(
    @PrimaryKey(autoGenerate = true)
    var id :Int= 0,
    var projectTitle: String,
    var projectDesc:String,
    var createdAt:Long = System.currentTimeMillis()
):Parcelable
