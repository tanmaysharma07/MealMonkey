package com.example.mymealmonkey.view.fragment.resetPasswordPage

import android.database.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordPageViewModel @Inject constructor(val eventListener: EventListener):ViewModel() {

    //UI Field
    val emailInput = ObservableField("")

    //Check if Email is Valid
    fun isEmail(): Boolean {
        return (!(android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput.get() ?: "").matches()))
    }
}