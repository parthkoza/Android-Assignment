package com.example.androiduidevelopment.que_4.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androiduidevelopment.R
import com.example.androiduidevelopment.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()

            Toast.makeText(
                context,
                """
                    EMail : $email|Password :- $password"
                """.trimIndent(),
                Toast.LENGTH_LONG).show()

        }

        binding.btnSignUp.setOnClickListener {

            var registrationFragment = SignUpFragment()

            var manager = requireActivity().supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, registrationFragment)
            transaction.commit()
        }

    }

}