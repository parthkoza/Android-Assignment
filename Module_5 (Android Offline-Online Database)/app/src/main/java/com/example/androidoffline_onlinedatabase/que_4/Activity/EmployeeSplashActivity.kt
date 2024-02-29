package com.example.androidoffline_onlinedatabase.que_4.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidoffline_onlinedatabase.databinding.ActivityEmployeeSplashBinding

class EmployeeSplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEmployeeSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(
            Runnable {
                Thread.sleep(3000)
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        ).start()
    }
}