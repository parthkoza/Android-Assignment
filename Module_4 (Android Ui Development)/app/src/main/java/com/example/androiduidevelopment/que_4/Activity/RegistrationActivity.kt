package com.example.androiduidevelopment.que_4.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.ActivityRegistrationBinding
import com.example.androiduidevelopment.que_4.Fragment.LoginFragment
import com.example.androiduidevelopment.que_4.Fragment.SignUpFragment

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var manager = supportFragmentManager
            var fragment  = LoginFragment()
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,fragment)
            transaction.commit()

        }

        binding.btnSignUp.setOnClickListener {
            var manager = supportFragmentManager
            var fragment = SignUpFragment()
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,fragment)
            transaction.commit()

        }


    }
}