package com.example.advancedandroiddevelopment.que10

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.advancedandroiddevelopment.R
import com.example.advancedandroiddevelopment.databinding.ActivityAnimationSplashBinding

class AnimationSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animation = AnimationUtils.loadAnimation(this,R.anim.splash_anim)
        binding.imageView.startAnimation(animation)
        binding.textView.startAnimation(animation)

        Thread(
            Runnable {
                Thread.sleep(7000)
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
            }
        ).start()
    }
}