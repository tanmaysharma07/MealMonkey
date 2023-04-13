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

    private  val viewModel: LoginPageViewModel by viewModels()
    private lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login_page, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()

        setListeners()

        bindObservers()


        }
    private fun bindObservers() {

    }

    private fun setListeners() {
        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_resetPasswordFragment)
        }
        binding.logInButton.setOnClickListener {
            if(viewModel.isEmail()){
                Toast.makeText(requireContext(),"Not valid Email",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(viewModel.isPassword()){
                Toast.makeText(requireContext(),"Not valid Password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            findNavController().navigate(R.id.action_loginPage_to_imageSliderFragment)
        }
    }

    private fun initialize() {
    }
}

