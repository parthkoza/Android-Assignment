package com.example.androidoffline_onlinedatabase.que_3.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidoffline_onlinedatabase.databinding.LayoutTaskBinding
import com.example.androidoffline_onlinedatabase.que_3.Model.Task

class TaskAdapter(var context: Context,var taskList: MutableList<Task>):Adapter<TaskAdapter.MyViewHolder>() {

    var btneditclicklistener:((position:Int,task:Task)->Unit)?=null
    var btnDeleteClickListener: ((position: Int, task:Task) -> Unit)? = null

    class MyViewHolder(var binding : LayoutTaskBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = LayoutTaskBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var task = taskList[position]

        holder.binding.tvTaskName.text = task.name
        holder.binding.tvTaskDescription.text = task.description
        holder.binding.tvTaskTime.text = task.time
        holder.binding.tvTaskDate.text = task.date

        when (task.priority) {
            "HIGH" -> holder.binding.root.setBackgroundColor(Color.RED)
            "AVERAGE" -> holder.binding.root.setBackgroundColor(Color.BLUE)
            "LOW" -> holder.binding.root.setBackgroundColor(Color.GREEN)
            else -> holder.binding.root.setBackgroundColor(Color.TRANSPARENT)
        }

        holder.binding.btnUpdate.setOnClickListener {
            btneditclicklistener?.invoke(position, task)
        }
        holder.binding.btnDelete.setOnClickListener {
            btnDeleteClickListener?.invoke(position, task)
        }
    }
    fun setItems(mutableList: MutableList<Task>) {
        this.taskList = mutableList
        notifyDataSetChanged()
    }
    fun deleteItem(position: Int){
        taskList.removeAt(position)
        notifyItemRemoved(position)
    }

}