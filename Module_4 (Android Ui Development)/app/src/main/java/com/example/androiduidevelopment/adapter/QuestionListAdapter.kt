package com.example.androiduidevelopment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androiduidevelopment.databinding.QuestionListLayoutBinding
import com.example.androiduidevelopment.model.Question
import com.example.androiduidevelopment.que_1.QuestionOneActivity
import com.example.androiduidevelopment.que_10.TextSizeActivity
import com.example.androiduidevelopment.que_11.EditTextActivity
import com.example.androiduidevelopment.que_12.CheckBoxActivity
import com.example.androiduidevelopment.que_14.StringListActivity
import com.example.androiduidevelopment.que_15.RadioButtonBackgroundColorActivity
import com.example.androiduidevelopment.que_16.SeekBarActivity
import com.example.androiduidevelopment.que_17.ToolBarActivity
import com.example.androiduidevelopment.que_2.PrintNumbersActivity
import com.example.androiduidevelopment.que_3.RadioButtonActivity
import com.example.androiduidevelopment.que_4.Activity.RegistrationActivity
import com.example.androiduidevelopment.que_7.TextViewActivity
import com.example.androiduidevelopment.que_8.TableLayoutMainActivity
import com.example.androiduidevelopment.que_9.PdfActivity

class QuestionListAdapter(
    private var context: Context,
    private var questionList: MutableList<Question>
) :
    Adapter<QuestionListAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: QuestionListLayoutBinding) : ViewHolder(binding.root)

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
                1 -> context.startActivity(Intent(context, QuestionOneActivity::class.java))
                2 -> context.startActivity(Intent(context, PrintNumbersActivity::class.java))
                3 -> context.startActivity(Intent(context, RadioButtonActivity::class.java))
                4 -> context.startActivity(Intent(context, RegistrationActivity::class.java))
                5 -> Toast.makeText(context, "Question is not from this Module", Toast.LENGTH_LONG).show()
                6 -> Toast.makeText(context, "Question is not from this Module", Toast.LENGTH_LONG).show()
                7 -> context.startActivity(Intent(context, TextViewActivity::class.java))
                8 -> context.startActivity(Intent(context,TableLayoutMainActivity::class.java))
                9 -> context.startActivity(Intent(context,PdfActivity::class.java))
                10 -> context.startActivity(Intent(context,TextSizeActivity::class.java))
                11 -> context.startActivity(Intent(context, EditTextActivity::class.java))
                12 -> context.startActivity(Intent(context,CheckBoxActivity::class.java))
                13 -> Toast.makeText(context, "Question is not from this Module", Toast.LENGTH_LONG).show()
                14 -> context.startActivity(Intent(context,StringListActivity::class.java))
                15 -> context.startActivity(Intent(context,RadioButtonBackgroundColorActivity::class.java))
                16 -> context.startActivity(Intent(context,SeekBarActivity::class.java))
                17 -> context.startActivity(Intent(context,ToolBarActivity::class.java))
            }
        }
    }
}