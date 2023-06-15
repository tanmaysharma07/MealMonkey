package com.example.mymealmonkey.view.fragment.resetPasswordPage

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.database.db.ProfileDatabase
import com.example.mymealmonkey.utils.EventListener
import com.example.mymealmonkey.utils.isNotValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordPageViewModel @Inject constructor(
    val profileDatabase: ProfileDatabase,
    val eventListener: EventListener
) : ViewModel() {

    //UI Field
    val emailInput = ObservableField("")

    //Check if Email is Valid
    fun isEmail(email: String?): Boolean {
        return ((emailInput.get()?.isNotValidEmail() ?: true) || (emailInput.get() != email))
    }
}