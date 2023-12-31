package com.example.mymealmonkey.view.fragment.signUpPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.ProfileData
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.databinding.FragmentSignUpPageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SignUpPage : Fragment() {

    // Initializing ViewModel
    private val viewModel: SignUpPageViewModel by viewModels()

    // Binding Component
    private lateinit var binding: FragmentSignUpPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Data Binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up_page, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Click Listeners
        clickListeners()
    }

    // Set Click Listeners
    private fun clickListeners() {

        //take to login Page on clicking Login Button
        binding.loginTextButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }

        //Sign Up account on click and goes to login page
        binding.signUpButton.setOnClickListener {

            //Check if Name is Valid
            if (viewModel.isName()) {
                binding.nameTextField.helperText = getString(R.string.enter_name)
                return@setOnClickListener
            }
            binding.nameTextField.helperText = null

            //check if email is valid or not
            if (viewModel.isEmail()) {
                binding.emailTextField.helperText = getString(R.string.enter_valid_email)
                return@setOnClickListener
            }
            binding.emailTextField.helperText = null

            //Check if Mobile Number is Valid
            if (viewModel.isMobileNumber()) {
                binding.mobileNoTextField.helperText = getString(R.string.enter_valid_mobile_number)
                return@setOnClickListener
            }
            binding.mobileNoTextField.helperText = null

            //Check if Address is Valid
            if (viewModel.isAddress()) {
                binding.addressTextField.helperText = getString(R.string.enter_address)
                return@setOnClickListener
            }
            binding.addressTextField.helperText = null

            //Check validity of Password
            if (viewModel.isPassword()) {
                binding.passwordSignUp.helperText = getString(R.string.enter_valid_password)
                binding.confirmPasswordSignUp.helperText = getString(R.string.enter_valid_password)
                return@setOnClickListener
            }
            binding.passwordSignUp.helperText = null
            binding.confirmPasswordSignUp.helperText = null

            // Save User Data
            val user = User(
                viewModel.nameInput.get(),
                viewModel.emailInput.get(),
                viewModel.mobileNumberInput.get(),
                viewModel.addressInput.get(),
                viewModel.passwordInput.get()
            )
            viewModel.signupSession(user)

            // Save User Profile Data
            val profileData = ProfileData(
                null,
                viewModel.nameInput.get(),
                viewModel.emailInput.get(),
                viewModel.mobileNumberInput.get(),
                viewModel.addressInput.get(),
                viewModel.passwordInput.get()
            )

            lifecycleScope.launch(Dispatchers.IO) {
                // Set the profile data
                viewModel.setProfileData(profileData)

                val userData =
                    viewModel.profileDatabase.profileDao().findByEmail(profileData.email ?: "")

                if (userData?.email != null) {
                    // Navigate to Login Page
                    findNavController().navigate(R.id.action_signUpPage_to_loginPage)
                }
            }
        }
    }
}
