package com.example.androiduidevelopment.que_4.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUp.setOnClickListener {
            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var number = binding.etNumber.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()

            Toast.makeText(
                context,
                """
                    Name : $name \nEMail : $email \nNumber :- $number \nPassword :- $password"
                """.trimMargin(),
                Toast.LENGTH_LONG).show()
        }

        binding.btnLogin.setOnClickListener {
            var loginFragment = LoginFragment()
            var manager = requireActivity().supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,loginFragment)
            transaction.commit()
        }
    }


}