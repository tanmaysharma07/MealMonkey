package com.example.mymealmonkey.view.fragment.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentLoginPageBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginPage : Fragment() {

    // View Model Initialized
    private val viewModel: LoginPageViewModel by viewModels()

    //Bonding Component
    private lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_page, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        val mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso);

        binding.googleButton.setOnClickListener {

            val existingUser = GoogleSignIn.getLastSignedInAccount(requireContext())

            if (existingUser != null) {
                mGoogleSignInClient.signOut()
                    .addOnCompleteListener(requireActivity()) {
                    }
            } else {
                val signInIntent: Intent = mGoogleSignInClient.signInIntent
                startActivityForResult(signInIntent, 100)
            }
        }

        // Set Click Listeners
        clickListeners()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 100) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

        } catch (e: ApiException) {
            Toast.makeText(
                requireContext(),
                "Error Occurred During Google SignIn",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun clickListeners() {
        binding.signUp.setOnClickListener {
            // Navigate to Sign Up Page
            findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }

        binding.forgotPassword.setOnClickListener {
            // Navigate to Reset Password Page
            findNavController().navigate(R.id.action_loginPage_to_resetPasswordFragment)
        }

        binding.logInButton.setOnClickListener {

            //check if email is valid or not
            if (viewModel.isEmail()) {
                binding.yourEmailTextField.helperText = "Enter Valid Email"
                return@setOnClickListener
            }
            binding.yourEmailTextField.helperText = null

            //check if email is valid or not
            if (viewModel.isPassword()) {
                binding.passwordTextField.helperText = "Enter Valid Password"
                return@setOnClickListener
            }
            binding.passwordTextField.helperText = null

            // Navigate to Image Slider Page
            findNavController().navigate(R.id.action_loginPage_to_imageSliderFragment)
        }
    }
}