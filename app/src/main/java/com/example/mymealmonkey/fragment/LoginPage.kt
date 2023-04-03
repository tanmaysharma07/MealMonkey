package com.example.mymealmonkey.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.mymealmonkey.R
import com.google.android.material.textfield.TextInputLayout


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

        val yourEmail:TextInputLayout = view.findViewById(R.id.your_email_textField)
        var loginPassword:TextInputLayout = view.findViewById(R.id.password_textField)
        val signUp:TextView = view.findViewById(R.id.sign_up)
        val forgotPassword:TextView = view.findViewById(R.id.forgot_password)
        val LoginButton:Button = view.findViewById(R.id.log_in_button)
        signUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }
        forgotPassword.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginPage_to_resetPasswordFragment)
        }
        LoginButton.setOnClickListener {
            if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(yourEmail.editText?.text.toString()).matches())){
                Toast.makeText(requireContext(),"Enter a Valid Email",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (loginPassword.editText?.text.toString().length<7){
                Toast.makeText(requireContext(),"Password Length not Enough",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                it.findNavController().navigate(R.id.action_loginPage_to_imageSliderFragment)
            }
        }
    }
}