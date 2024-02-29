package com.example.advancedandroiddevelopment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.advancedandroiddevelopment.databinding.QuestionListLayoutBinding
import com.example.advancedandroiddevelopment.que1.ImageActivity
import com.example.advancedandroiddevelopment.que10.AnimationSplashActivity
import com.example.advancedandroiddevelopment.que5.RotateImageActivity
import com.example.advancedandroiddevelopment.que6.BlinkImageActivity
import com.example.advancedandroiddevelopment.que7.MoveImageActivity
import com.example.advancedandroiddevelopment.que8.ZoomInOutActivity

class QuestionAdapter(var context:Context,var questionList: MutableList<Question>):Adapter<QuestionAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: QuestionListLayoutBinding):ViewHolder(binding.root)

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

        holder.binding.tvQuestion.setOnClickListener {
            when(question.id){
                1  ->  context.startActivity(Intent(context,ImageActivity::class.java))
                5  ->  context.startActivity(Intent(context,RotateImageActivity::class.java))
                6  ->  context.startActivity(Intent(context,BlinkImageActivity::class.java))
                7  ->  context.startActivity(Intent(context,MoveImageActivity::class.java))
                8  ->  context.startActivity(Intent(context,ZoomInOutActivity::class.java))
                10 ->  context.startActivity(Intent(context,AnimationSplashActivity::class.java))
            }
        }
    }
}