package com.example.androidadvanceddevlopment.Que_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.androidadvanceddevlopment.R
import com.example.androidadvanceddevlopment.databinding.ActivitySplashLogoBinding

class SplashLogoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashLogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashLogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        binding.imageView2.startAnimation(animation)

        Thread(
            Runnable {
                Thread.sleep(5000)
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
            }
        ).start()
    }
}