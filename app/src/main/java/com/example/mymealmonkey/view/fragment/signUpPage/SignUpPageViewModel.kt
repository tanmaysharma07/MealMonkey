package com.example.mymealmonkey.view.fragment.signUpPage

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpPageViewModel @Inject constructor(private val appPreferences: AppPreferences,val eventListener: EventListener) : ViewModel() {

    val emailInput = ObservableField("")
    val nameInput = ObservableField("")
    val mobileNumberInput = ObservableField("")
    val addressInput = ObservableField("")
    val passwordInput = ObservableField("")
    val confirmPasswordInput = ObservableField("")

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get()=_name
    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get()=_email
    private val _mobileNumber = MutableLiveData<String>()
    val mobileNumber: LiveData<String>
        get()=_mobileNumber
    private val _address = MutableLiveData<String>()
    val address: LiveData<String>
        get()=_address
    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get()=_password
    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String>
        get()=_confirmPassword

    fun signupSession(user: User) {
        return appPreferences.signUp(user)
    }

    fun isFilled():Boolean{
        _name.value = nameInput.get()
        _mobileNumber.value = mobileNumberInput.get()
        _address.value = addressInput.get()
        return ((name.value!!.trim()).isEmpty()&&(mobileNumber.value!!.trim()).isEmpty()&&(address.value!!.trim()).isEmpty())
    }
    fun isEmail():Boolean{
        _email.value = emailInput.get()
        return (!(android.util.Patterns.EMAIL_ADDRESS.matcher(email.value!!).matches()))
    }
    fun isPassword():Boolean{
        _password.value = passwordInput.get()
        _confirmPassword.value = confirmPasswordInput.get()
        return ((((passwordInput.get()!!.length) < 7 || (password.value != confirmPassword.value) || (confirmPassword.value!!.length) < 7)))
    }
}