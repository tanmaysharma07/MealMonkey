package com.example.mymealmonkey.view.fragment.startPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentStartPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartPage : Fragment() {

    private lateinit var binding: FragmentStartPageBinding
    private val startPageViewModel:StartPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startPageViewModel.eventListener.showBottomNavigationLD.postValue(false)

        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_startPage_to_loginPage)
        }
        binding.createAccountButton.setOnClickListener {
            findNavController().navigate(R.id.action_startPage_to_signUpPage)
        }
    }
}