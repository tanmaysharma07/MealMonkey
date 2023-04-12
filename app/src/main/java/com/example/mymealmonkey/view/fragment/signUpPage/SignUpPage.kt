package com.example.mymealmonkey.view.fragment.signUpPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.databinding.FragmentSignUpPageBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpPage : Fragment() {

    private val signupViewModel:SignUpPageViewModel by viewModels()
    private lateinit var binding:FragmentSignUpPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSignUpPageBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signupViewModel.eventListener.showBottomNavigationLD.postValue(false)
        binding.sigupPageViewModel = signupViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val name = binding.nameTextField.editText?.text
        val email= binding.emailTextField.editText?.text
        val mobileNumber = binding.mobileNoTextField.editText?.text
        val address = binding.addressTextField.editText?.text
        val password = binding.passwordSignUp.editText?.text
        val confirmPassword = binding.confirmPasswordSignUp.editText?.text

        binding.loginTextButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }
        binding.signUpButton.setOnClickListener {
            if (signupViewModel.isFilled()){
                Toast.makeText(requireContext(),"Enter all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (signupViewModel.isEmail()){
                Toast.makeText(requireContext(),"Enter a Valid Email",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (signupViewModel.isPassword()){
                Toast.makeText(requireContext(),"Enter Valid password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (signupViewModel.isPassword()){
                Toast.makeText(requireContext(),"Passwords Do not Match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val user = User(name.toString(),email.toString(),password.toString(),mobileNumber.toString(),address.toString())
            signupViewModel.signupSession(user)
                findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }
    }
}
