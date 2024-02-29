package com.example.androiduidevelopment.que_8

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityTableLayoutBinding

class TableLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTableLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var name = intent.getStringExtra("NAME")
        var address = intent.getStringExtra("ADDRESS")
        var contact = intent.getStringExtra("CONTACT")
        var course = intent.getStringExtra("COURSE")
        var email = intent.getStringExtra("EMAIL")
        var dob = intent.getStringExtra("DOB")

        binding.tvName.text = "Name :- $name"
        binding.tvDob.text = "DOB :- $dob"
        binding.tvCourse.text = "Course :- $course"
        binding.tvEmail.text = "Email :- $email"
        binding.tvAddress.text = "Address :- $address"
        binding.tvContact.text = "Contact :- $contact"

    }
}