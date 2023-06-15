package com.example.mymealmonkey.model


import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(
    private val appPreferences: AppPreferences,
    val eventListener: EventListener
) : ViewModel() {

    fun signupSession(user: User) {

        return appPreferences.signUp(user)
    }

    fun getUserDetails(): User? {

        return appPreferences.getUser()
    }
}