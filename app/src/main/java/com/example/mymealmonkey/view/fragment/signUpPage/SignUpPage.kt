package com.example.mymealmonkey.view.fragment.signUpPage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.databinding.FragmentSignUpPageBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpPage : Fragment() {

    // Initializing ViewModel
    private val viewModel: SignUpPageViewModel by viewModels()

    // Binding Component
    private lateinit var binding: FragmentSignUpPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up_page, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Click Listeners
        clickListeners()
    }

    // Set Click Listeners
    private fun clickListeners() {

        //take to login Page on clicking Login Button
        binding.loginTextButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }

        //Sign Up account on click and goes to login page
        binding.signUpButton.setOnClickListener {

            //Check if Name is Valid
            if (viewModel.isName()) {
                binding.nameTextField.helperText = "Enter Name"
                return@setOnClickListener
            }
            binding.nameTextField.helperText = null

            //check if email is valid or not
            if (viewModel.isEmail()) {
                binding.emailTextField.helperText = "Enter Valid Email"
                return@setOnClickListener
            }
            binding.emailTextField.helperText = null

            //Check if Mobile Number is Valid
            if (viewModel.isMobileNumber()) {
                binding.mobileNoTextField.helperText = "Enter Valid Mobile Number"
                return@setOnClickListener
            }
            binding.mobileNoTextField.helperText = null

            //Check if Address is Valid
            if (viewModel.isAddress()) {
                binding.addressTextField.helperText = "Enter Address"
                return@setOnClickListener
            }
            binding.addressTextField.helperText = null

            //Check validity of Password
            if (viewModel.isPassword()) {
                binding.passwordSignUp.helperText = "Enter Valid Password"
                binding.confirmPasswordSignUp.helperText = "Enter Valid Password"
                return@setOnClickListener
            }
            binding.passwordSignUp.helperText = null
            binding.confirmPasswordSignUp.helperText = null

            // Save User Data
            val user = User(
                viewModel.nameInput.get(),
                viewModel.emailInput.get(),
                viewModel.mobileNumberInput.get(),
                viewModel.addressInput.get(),
                viewModel.passwordInput.get()
            )
            viewModel.signupSession(user)

            // Navigate to Login Page
            findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }
    }
}
