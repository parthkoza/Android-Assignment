package com.example.androidfundamental.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidfundamental.model.Question
import com.example.androidfundamental.databinding.QuestionListLayoutBinding
import com.example.androidfundamental.que_1.HelloWorldActivity
import com.example.androidfundamental.que_2.ChangeBackgroundActivity
import com.example.androidfundamental.que_3_4.FirstActivity
import com.example.androidfundamental.que_5.LoginActivity
import com.example.androidfundamental.que_6.QueSixActivity
import com.example.androidfundamental.que_7.QueSevenActivity
import com.example.androidfundamental.que_8.QueEightActivity
import com.example.androidfundamental.que_9.QueNineActivity

class QuestionListAdapter(var context: Context, var questionList: MutableList<Question>) :
    Adapter<QuestionListAdapter.MyViewHolder>() {

    class MyViewHolder( var binding: QuestionListLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = QuestionListLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var question = questionList[position]
        holder.binding.tvQuestion.text = question.question

        holder.binding.cardQuestionLayout.setOnClickListener {
            when(question.id){
                1 -> context.startActivity(Intent(context,HelloWorldActivity::class.java))
                2 -> context.startActivity(Intent(context,ChangeBackgroundActivity::class.java))
                3 -> context.startActivity(Intent(context,FirstActivity::class.java))
                4 -> context.startActivity(Intent(context,FirstActivity::class.java))
                5 -> context.startActivity(Intent(context,LoginActivity::class.java))
                6 -> context.startActivity(Intent(context,QueSixActivity::class.java))
                7 -> context.startActivity(Intent(context,QueSevenActivity::class.java))
                8 -> context.startActivity(Intent(context,QueEightActivity::class.java))
                9 -> context.startActivity(Intent(context,QueNineActivity::class.java))
            }
        }
    }


}