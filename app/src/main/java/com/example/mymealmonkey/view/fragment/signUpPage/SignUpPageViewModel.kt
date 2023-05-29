package com.example.mymealmonkey.view.fragment.signUpPage

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.ProfileData
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpPageViewModel @Inject constructor(
    private val appPreferences: AppPreferences,
    val eventListener: EventListener
) : ViewModel() {

    //Observable Field to catch Data
    val emailInput = ObservableField("")
    val nameInput = ObservableField("")
    val mobileNumberInput = ObservableField("")
    val addressInput = ObservableField("")
    val passwordInput = ObservableField("")
    val confirmPasswordInput = ObservableField("")

    // Function to Store User Data
    fun signupSession(user: User) {
        return appPreferences.signUp(user)
    }

    // Function to Store User Data
    suspend fun setProfileData(profileData: ProfileData) {
        return appPreferences.setProfileData(profileData)
    }

    //Check if Name is Valid
    fun isName(): Boolean {
        return ((nameInput.get()?.trim()?.isEmpty() ?: true))
    }

    //Check if Email is Valid
    fun isEmail(): Boolean {
        return (!(android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput.get() ?: "").matches()))
    }

    //Check if Address is Valid
    fun isAddress(): Boolean {
        return (addressInput.get()?.trim()?.isEmpty() ?: true)
    }

    //Check if Mobile number is Valid
    fun isMobileNumber(): Boolean {
        return ((mobileNumberInput.get()?.trim()?.isEmpty()
            ?: true) || ((mobileNumberInput.get()?.length ?: 0) > 10))
    }

    //Check if Password is valid
    fun isPassword(): Boolean {
        return ((((passwordInput.get()?.length
            ?: 0) < 7 || (passwordInput.get() != confirmPasswordInput.get()) || (confirmPasswordInput.get()?.length
            ?: 0) < 7)))
    }
}