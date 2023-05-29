package com.example.mymealmonkey.view.fragment.profileFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    // Initializing ViewModel
    private val viewModel: ProfileFragmentViewModel by viewModels()

    //Binding Component
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Data binding the Fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ClickListener to catch Click action
        setListeners()

    }

    /**
     *  ClickListener to catch Click action
     */
    private fun setListeners() {

        // On Click Allow user to change profile data
        binding.editProfile.setOnClickListener {
            binding.nameProfileTextInput.isEnabled = true
            binding.emailTextInputProfile.isEnabled = true
            binding.addressTextInputProfile.isEnabled = true
            binding.mobileNumberTextInputProfile.isEnabled = true
            binding.passwordSignupTextInputProfile.isEnabled = true
            binding.confirmPasswordSignupTextInputProfile.isEnabled = true
        }

        // On Click lock and saves user profile data
        binding.saveButtonProfile.setOnClickListener {

            //Check if Name is Valid
            if (viewModel.isName()) {
                binding.nameProfile.helperText = "Enter Name"
                return@setOnClickListener
            }
            binding.nameProfile.helperText = null

            //check if email is valid or not
            if (viewModel.isEmail()) {
                binding.emailProfile.helperText = "Enter Valid Email"
                return@setOnClickListener
            }
            binding.emailProfile.helperText = null

            //Check if Mobile Number is Valid
            if (viewModel.isMobileNumber()) {
                binding.mobileNumberProfile.helperText = "Enter Valid Mobile Number"
                return@setOnClickListener
            }
            binding.mobileNumberProfile.helperText = null

            //Check if Address is Valid
            if (viewModel.isAddress()) {
                binding.addressProfile.helperText = "Enter Address"
                return@setOnClickListener
            }
            binding.addressProfile.helperText = null

            //Check validity of Password
            if (viewModel.isPassword()) {
                binding.passwordSignupProfile.helperText = "Enter Valid Password"
                binding.confirmPasswordSignupProfile.helperText = "Enter Valid Password"
                return@setOnClickListener
            }
            binding.passwordSignupProfile.helperText = null
            binding.confirmPasswordSignupProfile.helperText = null


            binding.nameProfileTextInput.isEnabled = false
            binding.emailTextInputProfile.isEnabled = false
            binding.addressTextInputProfile.isEnabled = false
            binding.mobileNumberTextInputProfile.isEnabled = false
            binding.passwordSignupTextInputProfile.isEnabled = false
            binding.confirmPasswordSignupTextInputProfile.isEnabled = false

            //Save Profile data to Shared Preferences
            viewModel.saveProfile()
        }
    }
}