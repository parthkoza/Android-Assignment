package com.example.androiduidevelopment.que_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiduidevelopment.databinding.ActivityNumberBinding

class NumberActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var num1=intent.getIntExtra("FIRST",0)
        var num2=intent.getIntExtra("LAST",0)

        var numbers=if(num1<=num2){
            (num1..num2).toList()
        }else{
            (num2..num1).toList()
        }

        binding.tvNumbers.text="""
            Numbers Are = 
            $numbers
        """.trimIndent()
    }
}