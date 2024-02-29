package com.example.advancedandroiddevelopment.que6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.advancedandroiddevelopment.R
import com.example.advancedandroiddevelopment.databinding.ActivityBlinkImageBinding

class BlinkImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlinkImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlinkImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animation : Animation = AnimationUtils.loadAnimation(this, R.anim.blink)
        binding.imageView.startAnimation(animation)
    }
}