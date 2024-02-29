package com.example.androidoffline_onlinedatabase.que_2.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidoffline_onlinedatabase.que_2.Model.Note

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Query(" Select * From note_table order by createdAt desc")
    fun getAllNotes():MutableList<Note>

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

}