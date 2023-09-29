package com.example.androidfundamental.que_3_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.databinding.ActivityFirstBinding
import com.example.androidfundamental.model.User

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitFirst.setOnClickListener() {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var age = if (binding.etAge.text.toString().isNotBlank()) binding.etAge.text.toString()
                .trim() else "0"

            var user = User(name, email, age.toInt())

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", user)
            startActivity(intent)
        }
    }
}