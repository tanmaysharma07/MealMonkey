package com.example.mymealmonkey.view.fragment.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.databinding.FragmentLoginPageBinding
import com.example.mymealmonkey.model.AppViewModel
import com.example.mymealmonkey.view.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginPage : Fragment() {

    private  val loginPageViewModel: LoginPageViewModel by viewModels()
    private lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login_page, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginViewModel = loginPageViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        loginPageViewModel.eventListener.showBottomNavigation.postValue(false)

        var yourEmail = binding.yourEmailTextField.editText?.text
        val loginPassword = binding.passwordTextField.editText?.text

        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_resetPasswordFragment)
        }
        binding.logInButton.setOnClickListener {
            if(loginPageViewModel.isEmail()){
                Toast.makeText(requireContext(),"Not valid Email",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(loginPageViewModel.isPassword()){
                Toast.makeText(requireContext(),"Not valid Password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
                findNavController().navigate(R.id.action_loginPage_to_imageSliderFragment)
            }
        }
    }

