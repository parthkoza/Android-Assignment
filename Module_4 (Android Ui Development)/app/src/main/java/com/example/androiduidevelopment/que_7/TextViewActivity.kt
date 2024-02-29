package com.example.androiduidevelopment.que_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityTextViewBinding

class TextViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            binding.tvLine.text = "Hello , How are You ?"
        }

        binding.btnHide.setOnClickListener {
            binding.tvLine.text = " "
        }


    }
}