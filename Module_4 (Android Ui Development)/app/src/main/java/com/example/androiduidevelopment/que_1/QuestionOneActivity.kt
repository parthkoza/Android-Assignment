package com.example.androiduidevelopment.que_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.androiduidevelopment.databinding.ActivityQuestionOneBinding

class QuestionOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionOneBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.etNumber.addTextChangedListener { it ->
            var originalNum = it.toString()
            var reversedNum = originalNum.reversed()
            binding.tvReverseNumber.text = "$reversedNum"
        }
    }
}