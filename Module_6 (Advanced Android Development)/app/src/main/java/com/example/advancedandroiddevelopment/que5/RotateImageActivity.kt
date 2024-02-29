package com.example.advancedandroiddevelopment.que5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.advancedandroiddevelopment.R
import com.example.advancedandroiddevelopment.databinding.ActivityRotateImageBinding

class RotateImageActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRotateImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRotateImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animation = AnimationUtils.loadAnimation(this,R.anim.rotation)
        binding.ivEarth.startAnimation(animation)


    }
}