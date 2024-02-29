package com.example.androiduidevelopment.que_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityCheckBoxBinding

class CheckBoxActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCheckBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                binding.tvText.visibility=View.VISIBLE
            }
            else{
                binding.tvText.visibility = View.GONE
            }
        }
    }
}