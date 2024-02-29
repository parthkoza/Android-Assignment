package com.example.androiduidevelopment.que_16

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.example.androiduidevelopment.databinding.ActivitySeekBarBinding

class SeekBarActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySeekBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sbRed.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var red = progress
                var green = 0
                var blue = 255 - progress
                var backGroundColor = Color.rgb(red, green, blue)

                binding.layout.setBackgroundColor(backGroundColor)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        binding.sbGreen.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var green = progress
                var red = 0
                var blue = 255 - progress
                var backGroundColor = Color.rgb(red, green, blue)

                binding.layout.setBackgroundColor(backGroundColor)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        binding.sbBlue.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var blue = progress
                var green = 0
                var red = 255 - progress


                var backGroundColor = Color.rgb(red, green, blue)

                binding.layout.setBackgroundColor(backGroundColor)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }
}