package com.example.androidoffline_onlinedatabase.que_2.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidoffline_onlinedatabase.que_2.Dao.NoteDao
import com.example.androidoffline_onlinedatabase.que_2.Model.Note


@Database(entities = [Note::class], version = 1)
abstract class NoteAppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private var INSTANCE: NoteAppDatabase? = null

        fun getInstance(context: Context): NoteAppDatabase? {
            synchronized(this) {
                INSTANCE = Room.databaseBuilder(context,NoteAppDatabase::class.java,"Note").allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
}