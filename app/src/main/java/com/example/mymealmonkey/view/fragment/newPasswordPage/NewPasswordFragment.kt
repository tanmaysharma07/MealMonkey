package com.example.mymealmonkey.view.fragment.newPasswordPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentNewPasswordBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewPasswordFragment : Fragment() {

    private val viewModel: NewPasswordPageViewModel by viewModels()
    lateinit var binding: FragmentNewPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_new_password, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpButton.setOnClickListener {

            if (viewModel.newPasswordInput.get() != viewModel.confirmPasswordInput.get()) {
                binding.newPasswordTextField.helperText = "Enter Valid Password"
                binding.confirmPasswordTextField.helperText = "Enter Valid Password"
                return@setOnClickListener
            }
            binding.newPasswordTextField.helperText = null
            binding.confirmPasswordTextField.helperText = null

            lifecycleScope.launch {
                viewModel.saveNewPassword()
            }

            findNavController().navigate(R.id.homePageFragment)
        }
    }
}