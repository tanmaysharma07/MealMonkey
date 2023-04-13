package com.example.mymealmonkey.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.provider.Telephony.Carriers.PASSWORD
import com.example.mymealmonkey.data.User
import com.google.gson.Gson


class AppPreferences(context: Context) {

    // Constant Keys
    companion object {
        const val SHARED_PREF = "SHARED_PREF"
        const val USER_DATA = "USER_DATA"
    }

    // Shared Preference
    private var preferences: SharedPreferences

    init {

        // Initialize Shared Preferences
        preferences = context.getSharedPreferences(SHARED_PREF, MODE_PRIVATE)
    }

    /**
     * Save User in Local DB
     *
     * @param user Object of [User]
     */
    fun signUp(user: User) {
        preferences.edit()?.apply {
            putString(USER_DATA, Gson().toJson(user))
            apply()
        }
    }

    /**
     * @return Saved Object of [User]
     */

    fun getUser(): User? {
        return try {
            Gson().fromJson(preferences.getString(USER_DATA, ""), User::class.java)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}





