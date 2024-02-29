package com.example.androidoffline_onlinedatabase.que_2.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "note_table")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var note:String,
    var createdAt:Long = System.currentTimeMillis()
):Parcelable
