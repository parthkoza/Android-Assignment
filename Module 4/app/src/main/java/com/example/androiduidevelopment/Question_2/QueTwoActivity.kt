package com.example.androiduidevelopment.Question_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityQueOneBinding
import com.example.androiduidevelopment.databinding.ActivityQueTwoBinding

class QueTwoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityQueTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQueTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
           // var firstNumber =binding.etNumber+1.
        }

    }
}