package com.example.androidadvanceddevlopment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidadvanceddevlopment.Que_1.SplashLogoActivity
import com.example.androidadvanceddevlopment.Que_2.RawSongActivity
import com.example.androidadvanceddevlopment.Que_3.PlaySongFromMemoryActivity
import com.example.androidadvanceddevlopment.Que_4.ApiMusicActivity
import com.example.androidadvanceddevlopment.Que_5.VideoPlayActivity
import com.example.androidadvanceddevlopment.Que_6.TextToSpeechActivity
import com.example.androidadvanceddevlopment.Que_7.WiFiStatusActivity
import com.example.androidadvanceddevlopment.databinding.LayoutQuestionBinding

class QuestionAdapter(var context: Context,var questionList: MutableList<Question>) :Adapter<QuestionAdapter.MyViewHolder>(){

    class MyViewHolder(var binding: LayoutQuestionBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = LayoutQuestionBinding.inflate(LayoutInflater.from(context),parent,false)
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
                1 -> context.startActivity(Intent(context, SplashLogoActivity::class.java))
                2 -> context.startActivity(Intent(context, RawSongActivity::class.java))
                3 -> context.startActivity(Intent(context, PlaySongFromMemoryActivity::class.java))
                4 -> context.startActivity(Intent(context, ApiMusicActivity::class.java))
                5 -> context.startActivity(Intent(context, VideoPlayActivity::class.java))
                6 -> context.startActivity(Intent(context, TextToSpeechActivity::class.java))
                7 -> context.startActivity(Intent(context, WiFiStatusActivity::class.java))
            }
        }
    }
}