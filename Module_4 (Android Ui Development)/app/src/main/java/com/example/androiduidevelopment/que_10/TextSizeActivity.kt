package com.example.androiduidevelopment.que_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityTextSizeBinding

class TextSizeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTextSizeBinding

    private var fontSize = 16f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextSizeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIncrease.setOnClickListener {
                fontSize+=4
            binding.tvText.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSize)
        }

        binding.btnDecrease.setOnClickListener {
            fontSize-=4
            binding.tvText.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSize)
        }
    }
}