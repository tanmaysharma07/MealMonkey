package com.example.mymealmonkey.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.model.AppViewModel
import com.google.android.material.textfield.TextInputLayout

class SignUpPage : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel:AppViewModel by viewModels()

        val name: TextInputLayout = view.findViewById(R.id.name_textField)
        val email: TextInputLayout = view.findViewById(R.id.email_textField)
        val mobileNumber: TextInputLayout = view.findViewById(R.id.mobile_no_textField)
        val address: TextInputLayout = view.findViewById(R.id.address_textField)
        val password: TextInputLayout = view.findViewById(R.id.password_sign_up)!!
        val confirmPassword: TextInputLayout = view.findViewById(R.id.confirm_password_sign_up)
        val login: TextView = view.findViewById(R.id.login_text_button)
        val signUpButton: Button = view.findViewById(R.id.sign_up_button)

        login.setOnClickListener {
            it.findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }
        signUpButton.setOnClickListener {
            if (viewModel.isFieldEmpty(name.editText?.text.toString())&&viewModel.isFieldEmpty(mobileNumber.editText?.text.toString())&&viewModel.isFieldEmpty(address.editText?.text.toString())){
                Toast.makeText(requireContext(),"Enter all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(email.editText?.text.toString()).matches())){
                Toast.makeText(requireContext(),"Enter a Valid Email",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.editText?.text.toString().length<7){
                Toast.makeText(requireContext(),"Enter Valid password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (confirmPassword.editText?.text.toString()!=password.editText?.text.toString()){
                Toast.makeText(requireContext(),"Passwords Do not Match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
                it.findNavController().navigate(R.id.action_signUpPage_to_loginPage)

        }
    }
}
