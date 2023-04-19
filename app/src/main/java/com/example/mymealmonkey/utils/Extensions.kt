package com.example.mymealmonkey.utils

import javax.inject.Inject
import javax.inject.Singleton

    fun String.isValidEmail(): Boolean {
        return (!(android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()))
    }

    fun isValidPassword(string: String):Boolean{
        return (string.length>7)
    }

    fun isValidInput(string: String):Boolean{
        return (string.trim().isNotEmpty())
    }
