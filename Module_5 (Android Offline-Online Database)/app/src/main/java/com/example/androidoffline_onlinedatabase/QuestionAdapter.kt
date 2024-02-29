package com.example.androidoffline_onlinedatabase

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidoffline_onlinedatabase.databinding.QuestionListLayoutBinding
import com.example.androidoffline_onlinedatabase.que_1.Activity.ToDoSplashActivity
import com.example.androidoffline_onlinedatabase.que_2.Activity.StickyNoteSplashActivity
import com.example.androidoffline_onlinedatabase.que_3.Activity.TaskManageMentSplashActivity
import com.example.androidoffline_onlinedatabase.que_4.Activity.EmployeeSplashActivity
import com.example.androidoffline_onlinedatabase.que_5.PhotoAddActivity

class QuestionListAdapter(
    private var context: Context,
    private var questionList: MutableList<Question>
) :
    RecyclerView.Adapter<QuestionListAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: QuestionListLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = QuestionListLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var question = questionList[position]

        holder.binding.tvQuestion.text = question.question

        holder.binding.tvQuestion.setOnClickListener {
            when (question.id) {
                1 -> context.startActivity(Intent(context, ToDoSplashActivity::class.java))
                2 -> context.startActivity(Intent(context, StickyNoteSplashActivity::class.java))
                3 -> context.startActivity(Intent(context, TaskManageMentSplashActivity::class.java))
                4 -> context.startActivity(Intent(context, EmployeeSplashActivity::class.java))
                5 -> context.startActivity(Intent(context, PhotoAddActivity::class.java))
            }
        }
    }
}