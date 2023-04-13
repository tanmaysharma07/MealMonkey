package com.example.mymealmonkey.view.fragment.newPasswordPage

import android.database.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewPasswordPageViewModel @Inject constructor(val eventListener: EventListener,val appPreferences: AppPreferences): ViewModel() {

    private val newPasswordInput = ObservableField("")
    private val confirmPasswordInput = ObservableField("")

    fun saveNewPassword(){

        val user = appPreferences.getUser()
        if ((newPasswordInput.get()?.length ?: 0) > 7 && newPasswordInput.get().equals(confirmPasswordInput.get()) ){
            val users = User(user?.username,user?.email,user?.mobileNo,user?.address,newPasswordInput.get())
            appPreferences.signUp(users)
        }



    }
}