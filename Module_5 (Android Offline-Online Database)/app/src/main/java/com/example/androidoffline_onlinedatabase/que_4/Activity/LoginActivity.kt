package com.example.androidoffline_onlinedatabase.que_4.Activity

import PrefManager
import RegisterResponse
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidoffline_onlinedatabase.databinding.ActivityLoginBinding
import com.example.androidoffline_onlinedatabase.que_4.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()

            userLoggedIn(email, password)

        }
    }

    private fun userLoggedIn(email: String, password: String) {
        ApiClient.init().loggedIn(6, email, password).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null) {
                        if (registerResponse.status == "success") {
                            if (password == "123456") {
                                val manager = PrefManager(applicationContext)
                                manager.updateLoginStatus(true)
                                startActivity(Intent(applicationContext, ProjectListActivity::class.java))
                                finish()
                            } else {
                                Toast.makeText(applicationContext, "Incorrect Password", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        } else {
                            // User not found in the database
                            Toast.makeText(applicationContext, "User not found", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("TAG", "on Failure : ")
            }

        })

    }
}