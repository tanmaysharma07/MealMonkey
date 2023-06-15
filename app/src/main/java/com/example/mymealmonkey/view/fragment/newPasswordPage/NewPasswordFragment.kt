package com.example.mymealmonkey.view.fragment.newPasswordPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentNewPasswordBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewPasswordFragment : Fragment() {

    //ViewModel Initialization
    private val viewModel: NewPasswordPageViewModel by viewModels()

    // Binding Component
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

            //Validate Password
            if (viewModel.isPasswordValid()) {
                binding.newPasswordTextField.helperText = getString(R.string.enter_valid_password)
                binding.confirmPasswordTextField.helperText =
                    getString(R.string.enter_valid_password)
                return@setOnClickListener
            }
            binding.newPasswordTextField.helperText = null
            binding.confirmPasswordTextField.helperText = null

            lifecycleScope.launch(Dispatchers.IO) {
                val profileData = viewModel.getProfileData(viewModel.eventListener.resetEmail)
                if (profileData?.password.toString().trim().isNotEmpty()) {
                    viewModel.saveNewPassword(profileData)
                } else {
                    Toast.makeText(context, getString(R.string.try_again), Toast.LENGTH_SHORT)
                        .show()
                    return@launch
                }
                findNavController().navigate(R.id.action_newPasswordFragment_to_loginPage)
            }
        }
    }
}