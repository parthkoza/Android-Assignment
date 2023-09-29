package com.example.androidfundamental.que_3_4

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.databinding.ActivitySecondBinding
import com.example.androidfundamental.model.User

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("USER",User::class.java)
        } else {
            intent.getParcelableExtra("USER")
        }

        user?.let {
            binding.tvResult.text = """
            name : ${it.name}
            email : ${it.email}
            age : ${it.age}
        """.trimIndent()
        }
    }
}