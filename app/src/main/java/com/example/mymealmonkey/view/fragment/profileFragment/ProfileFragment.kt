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