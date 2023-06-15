package com.example.mymealmonkey.view.fragment.otpPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentOtpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpFragment : Fragment() {

    //Initializing ViewModel
    private val viewModel: OtpPageViewModel by viewModels()

    //Binding Components
    lateinit var binding: FragmentOtpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View Binding
        binding = FragmentOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Click Listener
        setListeners()
    }

    //Set Click Listener
    private fun setListeners() {
        binding.sendButton.setOnClickListener {
            findNavController().navigate(R.id.action_otpFragment_to_newPasswordFragment)

        }
    }
}