package com.example.mymealmonkey.view.fragment.newPasswordPage

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.ProfileData
import com.example.mymealmonkey.database.db.ProfileDatabase
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import com.example.mymealmonkey.utils.isNotValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewPasswordPageViewModel @Inject constructor(
    val eventListener: EventListener,
    val appPreferences: AppPreferences,
    private val profileDatabase: ProfileDatabase
) : ViewModel() {

    // UI Fields
    val newPasswordInput = ObservableField("")
    val confirmPasswordInput = ObservableField("")

    // Get Profile Data for Particular Email
    suspend fun getProfileData(email: String): ProfileData? {
        return profileDatabase.profileDao().findByEmail(email)
    }

    fun isPasswordValid(): Boolean {
        return (newPasswordInput.get()
            ?.isNotValidPassword() ?: true || newPasswordInput.get() != confirmPasswordInput.get())
    }

    //Save the new Password
    suspend fun saveNewPassword(profileData: ProfileData?) {
        profileDatabase.profileDao().update(
            profileData?.name ?: "",
            profileData?.email ?: "",
            profileData?.mobileNo ?: "",
            profileData?.address ?: "",
            newPasswordInput.get() ?: ""
        )
    }
}