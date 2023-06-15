package com.example.mymealmonkey.view.fragment.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.ProfileData
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.database.db.ProfileDatabase
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import com.example.mymealmonkey.utils.isNotValidEmail
import com.example.mymealmonkey.utils.isNotValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginPageViewModel @Inject constructor(
    private val appPreferences: AppPreferences,
    val eventListener: EventListener,
    private val profileDatabase: ProfileDatabase
) : ViewModel() {

    //Observable Fields in UI
    val emailInput = ObservableField("email@gmail.com")
    val passwordInput = ObservableField("password ")

    // Get Profile from Room Database
    suspend fun getProfileData(): ProfileData? {
        return profileDatabase.profileDao().findByEmail(emailInput.get().toString())
    }

    // Save data in user shared preferences
    fun setProfileData(profile: ProfileData?) {
        val user = User(
            profile?.name,
            profile?.email,
            profile?.mobileNo,
            profile?.address,
            profile?.password,
        )
        appPreferences.signUp(user)
    }

    //Check If the Email entered is Valid or not
    fun isEmail(profile: ProfileData?): Boolean {
        return ((emailInput.get() ?: "").isNotValidEmail() || (emailInput.get()
            ?: "") != profile?.email)
    }

    //Check If the Password entered is Valid or not
    fun isPassword(profile: ProfileData?): Boolean {
        return ((passwordInput.get()?.isNotValidPassword()
            ?: true) || (passwordInput.get() != profile?.password.toString()))
    }
}
