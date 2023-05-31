package com.example.mymealmonkey.view.fragment.newPasswordPage

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.ProfileData
import com.example.mymealmonkey.database.ProfileDatabase
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class NewPasswordPageViewModel @Inject constructor(
    val eventListener: EventListener,
    val appPreferences: AppPreferences,
    val profileDatabase: ProfileDatabase
) : ViewModel() {

    val newPasswordInput = ObservableField("")
    val confirmPasswordInput = ObservableField("")

    private suspend fun getProfileData(email: String): ProfileData? {
        return profileDatabase.profileDao().findByEmail(email)
    }

    suspend fun saveNewPassword() {

        val profileData = runBlocking { getProfileData(eventListener.resetEmail) }
        if ((newPasswordInput.get()?.length ?: 0) > 7 && newPasswordInput.get()
                .equals(confirmPasswordInput.get())
        ) {
            profileDatabase.profileDao().update(
                profileData?.name ?: "",
                profileData?.email ?: "",
                profileData?.mobileNo ?: "",
                profileData?.address ?: "",
                newPasswordInput.get() ?: ""
            )
        }
    }
}