package com.example.advancedandroiddevelopment.que8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.advancedandroiddevelopment.MainActivity
import com.example.advancedandroiddevelopment.R
import com.example.advancedandroiddevelopment.databinding.ActivityZoomInOutBinding

class ZoomInOutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZoomInOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZoomInOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ZoomIn
        var animation : Animation = AnimationUtils.loadAnimation(this,R.anim.zoomin)
        binding.imageView.startAnimation(animation)

        //ZoomOut
        var animation2 : Animation = AnimationUtils.loadAnimation(this,R.anim.zoomout)
        binding.imageView2.startAnimation(animation2)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finishAffinity()
        }
    }
}