package com.example.mymealmonkey.view.fragment.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.ProfileData
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class LoginPageViewModel @Inject constructor(
    private val appPreferences: AppPreferences,
    val eventListener: EventListener
) : ViewModel() {

    //Observable Fields in UI
    val emailInput = ObservableField("email@gmail.com")
    val passwordInput = ObservableField("password ")

    // Data Class to store User information
    private val user: User? = getUserDetails()

    private suspend fun getProfileData(): ProfileData? {
        return appPreferences.getProfileData(emailInput.get().toString())
    }

    //Check If the Email entered is Valid or not
    fun isEmail(): Boolean {
        val profile: ProfileData? = runBlocking { getProfileData() }
        return ((!(android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput.get() ?: "")
            .matches())) || (emailInput.get() != profile?.email.toString()))
    }

    //Check If the Password entered is Valid or not
    fun isPassword(): Boolean {
        val profile: ProfileData? = runBlocking { getProfileData() }
        return ((passwordInput.get()?.length
            ?: 0) < 7 || (passwordInput.get() != profile?.password.toString()))
    }

    //Retrieve Stored User Data
    private fun getUserDetails(): User? {
        return appPreferences.getUser()
    }
}
