package com.example.mymealmonkey.view.fragment.login

import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.databinding.FragmentLoginPageBinding
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class LoginPageViewModel @Inject constructor(private val appPreferences: AppPreferences,val eventListener: EventListener) : ViewModel() {

    val emailInput = ObservableField("email@gmail.com")
    val passwordInput = ObservableField("password")

    private val _email = MutableLiveData<String>()
    val email:LiveData<String>
        get()=_email
    private val _password = MutableLiveData<String>()
    val password:LiveData<String>
        get()=_password

    private val user:User? = getUserDetails()

    fun isEmail():Boolean{
        _email.value = emailInput.toString()
        return ((!(android.util.Patterns.EMAIL_ADDRESS.matcher(email.value)
            .matches())) || (email.value != user?.email.toString()))
    }
    fun isPassword():Boolean{
        _password.value = passwordInput.toString()
        return (password.value!!.length < 7 || (password.value != user?.password.toString()))
    }
    private fun getUserDetails(): User? {
        return appPreferences.getUser()
    }

}
