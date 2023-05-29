package com.example.mymealmonkey.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.mymealmonkey.data.CardDetailsData
import com.example.mymealmonkey.data.User
import com.example.mymealmonkey.data.ProfileData
import com.example.mymealmonkey.database.CardDetailsDatabase
import com.example.mymealmonkey.database.ProfileDatabase
import com.google.gson.Gson


class AppPreferences(context: Context) {

    // Constant Keys
    companion object {
        const val SHARED_PREF = "SHARED_PREF"
        const val USER_DATA = "USER_DATA"
    }

    // Shared Preference
    private var preferences: SharedPreferences

    // Profile Database
    private var profileDB: ProfileDatabase

    // Card Details Database
    private var cardDetailsDB: CardDetailsDatabase

    init {
        // Initialize Shared Preferences
        preferences = context.getSharedPreferences(SHARED_PREF, MODE_PRIVATE)

        // Initialize Profile Database
        profileDB = ProfileDatabase.getProfileDatabase(context)

        // Initialize Profile Database
        cardDetailsDB = CardDetailsDatabase.getCardDetailsDatabase(context)

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

    suspend fun getProfileData(email: String): ProfileData? {
        return profileDB.profileDao().findByEmail(email)
    }

    suspend fun updateProfileData(
        name: String,
        email: String,
        mobileNo: String,
        address: String,
        password: String
    ) {
        profileDB.profileDao().update(name, email, mobileNo, address, password)
    }

    suspend fun setProfileData(profileData: ProfileData) {
        profileDB.profileDao().insert(profileData)
    }

    suspend fun getCardNumber(): List<String>? {
        return cardDetailsDB.cardDetailsDao().getCardNumber()
    }

    suspend fun deleteCardNumber(cardNumber: String) {
        return cardDetailsDB.cardDetailsDao().deleteCard(cardNumber)
    }

    suspend fun updateCardDetailsData(
        cardNumber: String,
        expiryMonth: String,
        expiryYear: String,
        securityCode: String,
        firstName: String,
        lastName: String
    ) {
        cardDetailsDB.cardDetailsDao()
            .update(cardNumber, expiryMonth, expiryYear, securityCode, firstName, lastName)
    }

    suspend fun setCardDetailsData(cardDetailsData: CardDetailsData) {
        cardDetailsDB.cardDetailsDao().insert(cardDetailsData)
    }
}





