package com.example.androiduidevelopment.que_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityPrintNumbersBinding

class PrintNumbersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrintNumbersBinding

    private var num1 = 0
    private var num2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrintNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnter.setOnClickListener {
            num1 = binding.etNum1.text.toString().trim().toInt()
            num2 = binding.etNum2.text.toString().trim().toInt()


            var intent=Intent(this,NumberActivity::class.java)
            intent.putExtra("FIRST",num1)
            intent.putExtra("LAST",num2)
            startActivity(intent)

        }


    }
}