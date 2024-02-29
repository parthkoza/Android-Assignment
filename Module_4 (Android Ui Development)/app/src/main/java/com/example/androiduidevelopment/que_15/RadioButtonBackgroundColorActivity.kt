package com.example.androiduidevelopment.que_15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityRadioButtonBackgroundColorBinding

class RadioButtonBackgroundColorActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRadioButtonBackgroundColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioButtonBackgroundColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    fun onRadioButtonClick(view: View) {
        when(view.id){
            R.id.rb_white -> binding.layout.setBackgroundResource(R.color.white)
            R.id.rb_grey -> binding.layout.setBackgroundResource(R.color.grey)
            R.id.rb_blue -> binding.layout.setBackgroundResource(R.color.blue)
            R.id.rb_green -> binding.layout.setBackgroundResource(R.color.green)
            R.id.rb_red -> binding.layout.setBackgroundResource(R.color.red)
            R.id.rb_yellow -> binding.layout.setBackgroundResource(R.color.yellow)
            R.id.rb_orange -> binding.layout.setBackgroundResource(R.color.orange)
        }
    }
}