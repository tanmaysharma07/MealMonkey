package com.example.mymealmonkey.view.fragment.profileFragment

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileFragmentViewModel @Inject constructor(
    val eventListener: EventListener,
    private val appPreferences: AppPreferences
) : ViewModel() {

    // Function that return Stored User Data
    private fun getUserDetails(): User? {
        return appPreferences.getUser()
    }

    private val user = getUserDetails()

    // Observable Fields catch live Data
    val nameProfileInput = ObservableField(user?.username)
    val emailProfileInput = ObservableField(user?.email)
    val mobileNumberProfileInput = ObservableField(user?.mobileNo)
    val addressProfileInput = ObservableField(user?.address)
    val passwordProfileInput = ObservableField(user?.password)
    val confirmPasswordProfileInput = ObservableField(user?.password)

    // Function that Store the updated User Data
    fun saveProfile() {
        val users = User(
            nameProfileInput.get(),
            emailProfileInput.get(),
            mobileNumberProfileInput.get(),
            addressProfileInput.get(),
            passwordProfileInput.get()
        )
        appPreferences.signUp(users)
    }

    //Check if Name is Valid
    fun isName(): Boolean {
        return ((nameProfileInput.get()?.trim()?.isEmpty() ?: true))
    }

    //Check if Email is Valid
    fun isEmail(): Boolean {
        return (!(android.util.Patterns.EMAIL_ADDRESS.matcher(emailProfileInput.get() ?: "")
            .matches()))
    }

    //Check if Address is Valid
    fun isAddress(): Boolean {
        return (addressProfileInput.get()?.trim()?.isEmpty() ?: true)
    }

    //Check if Mobile number is Valid
    fun isMobileNumber(): Boolean {
        return ((mobileNumberProfileInput.get()?.trim()?.isEmpty()
            ?: true) || ((mobileNumberProfileInput.get()?.length ?: 0) > 10))
    }

    //Check if Password is valid
    fun isPassword(): Boolean {
        return ((((passwordProfileInput.get()?.length
            ?: 0) < 7 || (passwordProfileInput.get() != confirmPasswordProfileInput.get()) || (confirmPasswordProfileInput.get()?.length
            ?: 0) < 7)))
    }

}