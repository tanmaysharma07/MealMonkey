package com.example.mymealmonkey.view.fragment.profileFragment

import android.database.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileFragmentViewModel @Inject constructor(val eventListener: EventListener,val appPreferences: AppPreferences) : ViewModel() {

    private fun getUserDetails(): User? {
        return appPreferences.getUser()
    }

    val user = getUserDetails()

    val defaultName = user?.username
    val defaultEmail = user?.username
    val defaultMobileNumber = user?.username
    val defaultAddress = user?.username
    val defaultPassword = user?.username
    val defaultConfirmPassword = user?.username

    val nameProfleInput = ObservableField(defaultName)
    val emailProfleInput = ObservableField(defaultEmail)
    val mobileNumberProfleInput= ObservableField(defaultMobileNumber)
    val addressProfleInput = ObservableField(defaultAddress)
    val passwordProfleInput = ObservableField(defaultPassword)
    val confirmPasswordProfleInput = ObservableField(defaultConfirmPassword)
}