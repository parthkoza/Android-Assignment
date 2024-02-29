package com.example.androidoffline_onlinedatabase.que_1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidoffline_onlinedatabase.databinding.ActivityToDoSplashBinding

class ToDoSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToDoSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(
            Runnable {
                Thread.sleep(3000)
                startActivity(Intent(this, ToDoAppActivity::class.java))
                finish()
            }
        ).start()
    }
}