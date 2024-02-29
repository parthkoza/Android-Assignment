package com.example.androidoffline_onlinedatabase.que_2.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidoffline_onlinedatabase.databinding.ActivityStickyNoteSplashBinding

class StickyNoteSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStickyNoteSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStickyNoteSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(
            Runnable {
                Thread.sleep(3000)
                startActivity(Intent(this, StickyNoteAppActivity::class.java))
                finish()
            }
        ).start()
    }
}