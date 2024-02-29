package com.example.advancedandroiddevelopment.que7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.advancedandroiddevelopment.R
import com.example.advancedandroiddevelopment.databinding.ActivityMoveImageBinding

class MoveImageActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMoveImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animation = AnimationUtils.loadAnimation(this,R.anim.translate)
        binding.imageView.startAnimation(animation)

    }
}