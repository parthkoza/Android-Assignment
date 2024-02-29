package com.example.androiduidevelopment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androiduidevelopment.Question_1.QueOneActivity
import com.example.androiduidevelopment.databinding.QuestionListLayoutBinding
import com.example.androiduidevelopment.model.Question

class QuestionListAdapter(var context: Context, var questionList: MutableList<Question>) :
    Adapter<QuestionListAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: QuestionListLayoutBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = QuestionListLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var question: Question = questionList[position]
        holder.binding.tvQuestion.text=question.question

      holder.binding.cardQuestionLayout.setOnClickListener {
          when(question.id){
              1 -> context.startActivity(Intent(context, QueOneActivity::class.java))
          }
      }

    }


}