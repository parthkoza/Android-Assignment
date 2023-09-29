package com.example.androidfundamental.que_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidfundamental.R
import com.example.androidfundamental.databinding.ActivityChangeBackgroundBinding

class ChangeBackgroundActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChangeBackgroundBinding
    private var colorList = mutableListOf<Int>(R.color.black,R.color.white,R.color.red,R.color.blue,)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChangeBackgroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangeBg.setOnClickListener {
            binding.layoutMain.setBackgroundColor(ContextCompat.getColor(this,getRandomColor()))
        }
    }

    private fun getRandomColor(): Int {
            return colorList.shuffled().last()
    }
}