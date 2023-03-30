package com.example.mymealmonkey.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.mymealmonkey.R


class LoginPage : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_login_page, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var signUp:TextView = view.findViewById(R.id.sign_up)
        var forgotPassword:TextView = view.findViewById(R.id.forgot_password)
        var LoginButton:Button = view.findViewById(R.id.log_in_button)
        signUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }
        forgotPassword.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginPage_to_resetPasswordFragment)
        }
        LoginButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginPage_to_foodYouLoveFragment)
        }
    }
}