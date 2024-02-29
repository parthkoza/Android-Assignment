package com.example.androiduidevelopment.que_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityRadioButtonBinding

class RadioButtonActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRadioButtonBinding

    private var num1 = 0.0
    private var num2 = 0.0
    private var answer = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCalculate.setOnClickListener {
            num1 = binding.etNum1.text.toString().trim().toDouble()
            num2 = binding.etNum2.text.toString().trim().toDouble()

            when(binding.radioGroup.checkedRadioButtonId){
                R.id.btn_add -> answer = num1 + num2
                R.id.btn_sub -> answer = num1 - num2
                R.id.btn_multi -> answer = num1 * num2
                R.id.btn_div -> answer = num1 / num2
            }
            binding.tvAnswer.text = "$answer"
        }

        binding.btnReset.setOnClickListener {
            binding.etNum1.text.clear()
            binding.etNum2.text.clear()
            binding.tvAnswer.text=""
        }
    }
}