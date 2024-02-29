package com.example.androidoffline_onlinedatabase.que_2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidoffline_onlinedatabase.databinding.LayoutNoteBinding
import com.example.androidoffline_onlinedatabase.que_2.Model.Note

class NoteAdapter(var context: Context,var noteList: MutableList<Note>):Adapter<NoteAdapter.MyViewHolder>() {

    var itemEditClickListener: ((position: Int, note: Note) -> Unit)? = null
    var itemDeleteClickListener: ((position: Int, note: Note) -> Unit)? = null

    class MyViewHolder(var binding : LayoutNoteBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = LayoutNoteBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var note = noteList[position]

        holder.binding.tvNote.text = note.note

        holder.binding.btnEdit.setOnClickListener {
            itemEditClickListener?.invoke(position,note)
        }
        holder.binding.btnDelete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, note)
        }

    }

    fun setItems(mutableList: MutableList<Note>) {
        this.noteList = mutableList
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int){
        noteList.removeAt(position)
        notifyItemRemoved(position)
    }

}