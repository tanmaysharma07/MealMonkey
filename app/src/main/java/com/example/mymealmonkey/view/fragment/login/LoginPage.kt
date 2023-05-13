package com.example.mymealmonkey.view.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentLoginPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginPage : Fragment() {

    private val viewModel: LoginPageViewModel by viewModels()
    private lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_page, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Click Listeners
        clickListeners()
    }

    private fun clickListeners() {
        binding.signUp.setOnClickListener {
            // Navigate to Sign Up Page
            findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }
        binding.forgotPassword.setOnClickListener {
            // Navigate to Reset Password Page
            findNavController().navigate(R.id.action_loginPage_to_resetPasswordFragment)
        }
        binding.logInButton.setOnClickListener {
            //check if email is valid or not
            if (viewModel.isEmail()) {
                binding.yourEmailTextField.helperText = "Enter Valid Email"
                return@setOnClickListener
            }
            binding.yourEmailTextField.helperText = null

            //check if email is valid or not
            if (viewModel.isPassword()) {
                binding.passwordTextField.helperText = "Enter Valid Password"
                return@setOnClickListener
            }
            binding.passwordTextField.helperText = null

            // Navigate to Image Slider Page
            findNavController().navigate(R.id.action_loginPage_to_imageSliderFragment)
        }
    }
}

