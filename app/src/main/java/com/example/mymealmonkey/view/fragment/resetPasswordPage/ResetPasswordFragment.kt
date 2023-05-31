package com.example.mymealmonkey.view.fragment.resetPasswordPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentResetPasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment() {

    // Binding Component
    private lateinit var binding: FragmentResetPasswordBinding

    //Initializing ViewModel
    private val viewModel: ResetPasswordPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_reset_password, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListeners()
    }

    private fun clickListeners() {
        binding.sendButton.setOnClickListener {
            //check if email is valid or not
            if (viewModel.isEmail()) {
                binding.sendEmail.helperText = getString(R.string.enter_valid_email)
                return@setOnClickListener
            }
            binding.sendEmail.helperText = null

            //Update Reset Email
            viewModel.eventListener.resetEmail = viewModel.emailInput.get().toString()

            // Navigate to OTP Page
            findNavController().navigate(R.id.action_resetPasswordFragment_to_otpFragment)
        }
    }
}
