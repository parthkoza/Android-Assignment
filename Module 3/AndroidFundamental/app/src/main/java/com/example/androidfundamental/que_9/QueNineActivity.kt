package com.example.androidfundamental.que_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamental.R
import com.example.androidfundamental.databinding.ActivityQueNineBinding

class QueNineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQueNineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQueNineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoToFragment.setOnClickListener {
            var queNineFragment = QueNineFragment()

            var manager = supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.add(R.id.fragment_container, queNineFragment)
            transaction.commit()
        }
    }
}