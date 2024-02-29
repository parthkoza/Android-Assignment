package com.example.androidoffline_onlinedatabase.que_2.Activity

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoffline_onlinedatabase.databinding.ActivityNoteAddBinding
import com.example.androidoffline_onlinedatabase.que_2.Adapter.NoteAdapter
import com.example.androidoffline_onlinedatabase.que_2.Database.NoteAppDatabase
import com.example.androidoffline_onlinedatabase.que_2.Model.Note
import kotlin.concurrent.thread

class NoteAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteAddBinding
    private var db: NoteAppDatabase? = null
    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteAppDatabase.getInstance(this)

        note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("NOTE",Note::class.java)
        }else{
            intent.getParcelableExtra("Note")
        }

        note?.let {
            binding.etNote.setText(it.note)
            binding.btnAddNote.text = "Update Note"
        }

        binding.btnAddNote.setOnClickListener {
            var notes = binding.etNote.text.toString().trim()
            
            updateNote(notes)
        }

    }

    private fun updateNote(notes: String) {
        var message = ""

        thread (start = true){
            var noteObject = Note(
                id = if (note!=null)note!!.id else 0,
                note = notes,
                createdAt = if (note!=null)note!!.createdAt else System.currentTimeMillis(),
                )

            try {
                if (note!= null){
                    //Update
                    db!!.noteDao().updateNote(noteObject)
                    message = "Note Update Successfully"
                }else{
                    //Add
                    db!!.noteDao().insertNote(noteObject)
                    message = "Note Added Successfully"
                }
                runOnUiThread {
                    Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                    onBackPressedDispatcher.onBackPressed()
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

    }
}