package com.example.androidoffline_onlinedatabase.que_1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidoffline_onlinedatabase.databinding.LayoutTodoItemBinding
import com.example.androidoffline_onlinedatabase.que_1.Model.Todo

class ToDoAdapter(var context: Context, var taskList:MutableList<Todo>):Adapter<ToDoAdapter.TodoMyViewHolder>() {

    var itemEditClickListener:((position:Int,task:Todo)->Unit)?=null
    var itemDeleteClickListener:((position:Int,task:Todo)->Unit)?=null
    class TodoMyViewHolder(var binding: LayoutTodoItemBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoMyViewHolder {
        var binding = LayoutTodoItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return TodoMyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TodoMyViewHolder, position: Int) {
        var task = taskList[position]

        holder.binding.todoTitle.text = task.title
        holder.binding.tvTask.text = task.desc

        holder.binding.btnDelete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, task)
        }
        holder.binding.btnEdit.setOnClickListener {
            itemEditClickListener?.invoke(position, task)
        }
    }

    fun setItems(mutableList: MutableList<Todo>){
        this.taskList = mutableList
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int){
        taskList.removeAt(position)
        notifyItemRemoved(position)
    }

}