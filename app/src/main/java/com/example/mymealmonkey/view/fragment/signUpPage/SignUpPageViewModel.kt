package com.example.mymealmonkey.view.fragment.signUpPage

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.ProfileData
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.database.db.ProfileDatabase
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import com.example.mymealmonkey.utils.isNotValidEmail
import com.example.mymealmonkey.utils.isNotValidInput
import com.example.mymealmonkey.utils.isNotValidMobileNumber
import com.example.mymealmonkey.utils.isNotValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpPageViewModel @Inject constructor(
    private val appPreferences: AppPreferences,
    val eventListener: EventListener,
    val profileDatabase: ProfileDatabase
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
        return profileDatabase.profileDao().insert(profileData)
    }

    //Check if Name is Valid
    fun isName(): Boolean {
        return ((nameInput.get()?.isNotValidInput() ?: true))
    }

    //Check if Email is Valid
    fun isEmail(): Boolean {
        return (emailInput.get()?.isNotValidEmail() ?: true)
    }

    //Check if Address is Valid
    fun isAddress(): Boolean {
        return (addressInput.get()?.isNotValidInput() ?: true)
    }

    //Check if Mobile number is Valid
    fun isMobileNumber(): Boolean {
        return (mobileNumberInput.get()?.isNotValidMobileNumber()
            ?: true)
    }

    //Check if Password is valid
    fun isPassword(): Boolean {
        return ((passwordInput.get()?.isNotValidPassword()
            ?: true) || (passwordInput.get() != confirmPasswordInput.get()) || (confirmPasswordInput.get()
            ?.isNotValidPassword() ?: true))
    }
}