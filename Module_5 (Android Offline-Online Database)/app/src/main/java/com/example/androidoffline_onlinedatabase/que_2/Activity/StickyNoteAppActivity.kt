package com.example.androidoffline_onlinedatabase.que_2.Activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidoffline_onlinedatabase.databinding.ActivityStickyNoteAppBinding
import com.example.androidoffline_onlinedatabase.que_2.Adapter.NoteAdapter
import com.example.androidoffline_onlinedatabase.que_2.Database.NoteAppDatabase
import com.example.androidoffline_onlinedatabase.que_2.Model.Note

class StickyNoteAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStickyNoteAppBinding
    private lateinit var noteAdapter: NoteAdapter
    private var noteList = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStickyNoteAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteAdapter = NoteAdapter(this,noteList)
        binding.rvNoteList.adapter = noteAdapter
        binding.rvNoteList.layoutManager = LinearLayoutManager(this)

        binding.btnAddNote.setOnClickListener {
            startActivity(Intent(this,NoteAddActivity::class.java))
        }

        noteAdapter.itemEditClickListener = {position, cuisine ->
            var intent = Intent(this,NoteAddActivity::class.java)
            intent.putExtra("CUISINE",cuisine)
            startActivity(intent)
        }

        noteAdapter.itemDeleteClickListener = {position, cuisine ->
            try {
                showCustomDialog(position,cuisine)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

    }

    private fun showCustomDialog(position: Int, cuisine: Note) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete ?")
            .setMessage("Are you sure you want to delete this note?")
            .setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
                NoteAppDatabase.getInstance(this)!!.noteDao().deleteNote(cuisine)
                Toast.makeText(this, "Note Deleted...", Toast.LENGTH_SHORT).show()
                noteAdapter.deleteItem(position)
            }).setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->

            })

        var dialog =builder.create()
        dialog.show()

    }

    override fun onResume() {
        super.onResume()
        readNoteList()
    }

    private fun readNoteList() {
        noteList = NoteAppDatabase.getInstance(this)?.noteDao()!!.getAllNotes()
        noteAdapter.setItems(noteList)
    }

}