package com.example.androidoffline_onlinedatabase.que_4.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidoffline_onlinedatabase.databinding.LayoutProjectBinding
import com.example.androidoffline_onlinedatabase.que_4.Model.Project

class ProjectAdapter(var context: Context, var projectList: MutableList<Project>) :
    Adapter<ProjectAdapter.MyViewHolder>() {

    var itemEditClickListener: ((position: Int, cuisine: Project) -> Unit)? = null
    var itemDeleteClickListener: ((position: Int, cuisine: Project) -> Unit)? = null

    class MyViewHolder(var binding: LayoutProjectBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = LayoutProjectBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return projectList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var project = projectList[position]

        holder.binding.tvTitle.text = project.projectTitle
        holder.binding.tvDesc.text = project.projectDesc
        holder.binding.tvTime.text = project.createdAt.toString()


        holder.binding.ivEdit.setOnClickListener {
            itemEditClickListener?.invoke(position,project)
        }

        holder.binding.ivDelete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, project)
        }
    }

    fun setItem(mutableList: MutableList<Project>) {
        this.projectList = mutableList
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        projectList.removeAt(position)
        notifyItemRemoved(position)
    }
}