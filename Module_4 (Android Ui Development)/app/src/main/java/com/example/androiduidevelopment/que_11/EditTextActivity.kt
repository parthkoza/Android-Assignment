package com.example.androiduidevelopment.que_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityEditTextBinding

class EditTextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {

            val number = binding.etNumber.text.toString().trim().toInt()

            for (i in 0 until number) {
                val editText = EditText(this)
                editText.hint = "EditText ${i + 1}"
                binding.layout.addView(editText)
            }
        }

        binding.btnReset.setOnClickListener {
            Toast.makeText(this, "Ask sir How to reset it!", Toast.LENGTH_SHORT).show()
        }

    }
}