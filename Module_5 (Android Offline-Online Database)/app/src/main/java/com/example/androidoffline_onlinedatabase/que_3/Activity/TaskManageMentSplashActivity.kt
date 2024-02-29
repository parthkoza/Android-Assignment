package com.example.androidoffline_onlinedatabase.que_3.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidoffline_onlinedatabase.R
import com.example.androidoffline_onlinedatabase.databinding.ActivityTaskManageMentSplashBinding

class TaskManageMentSplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTaskManageMentSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskManageMentSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(
            Runnable {
                Thread.sleep(3000)
                startActivity(Intent(this,TaskManagementAppActivity::class.java))
                finish()
            }
        ).start()
    }
}