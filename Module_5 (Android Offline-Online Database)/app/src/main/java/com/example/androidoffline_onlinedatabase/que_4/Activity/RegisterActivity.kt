package com.example.androidoffline_onlinedatabase.que_4.Activity

import RegisterResponse
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidoffline_onlinedatabase.databinding.ActivityRegisterBinding
import com.example.androidoffline_onlinedatabase.que_4.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        
        binding.btnSignUp.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val contact = binding.etContact.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            createAccount(name, email, contact,password)

        }
    }

    private fun createAccount(name: String, email: String, contact: String, password: String) {
        ApiClient.init().create(1, name, email, contact)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        var res = response.body()

                        if (res != null) {
                            Toast.makeText(applicationContext, res.message, Toast.LENGTH_SHORT)
                                .show()

                            if (res.status =="success"){
                                startActivity(Intent(applicationContext,ProjectListActivity::class.java))
                            }

                        }
                    }
                }
                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("TAG","onFailure : ")
                }
            })

    }
}