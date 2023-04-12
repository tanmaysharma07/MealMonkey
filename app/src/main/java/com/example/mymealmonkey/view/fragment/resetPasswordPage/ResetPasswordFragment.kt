package com.example.mymealmonkey.view.fragment.resetPasswordPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentResetPasswordBinding
import com.example.mymealmonkey.view.fragment.otpPage.OtpPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment() {

    private lateinit var binding:FragmentResetPasswordBinding
    private val resetPasswordPageViewModel: ResetPasswordPageViewModel by viewModels()

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {binding = FragmentResetPasswordBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetPasswordPageViewModel.eventListener.showBottomNavigation.postValue(false)

        binding.sendButton.setOnClickListener {
            findNavController().navigate(R.id.action_resetPasswordFragment_to_otpFragment)
        }
    }

}
