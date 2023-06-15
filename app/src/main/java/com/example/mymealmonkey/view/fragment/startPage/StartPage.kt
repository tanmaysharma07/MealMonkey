package com.example.mymealmonkey.view.fragment.startPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentStartPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartPage : Fragment() {

    // Binding Components
    private lateinit var binding: FragmentStartPageBinding

    //Initializing ViewModel
    private val viewModel: StartPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //View Binding
        binding = FragmentStartPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Click Listeners
        clickListeners()
    }

    //Set Click Listeners
    private fun clickListeners() {
        binding.loginButton.setOnClickListener {
            // Navigate to Login Page
            findNavController().navigate(R.id.action_startPage_to_loginPage)
        }
        binding.createAccountButton.setOnClickListener {
            // Navigate to Sign up Page
            findNavController().navigate(R.id.action_startPage_to_signUpPage)
        }
    }
}