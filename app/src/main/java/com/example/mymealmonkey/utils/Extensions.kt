package com.example.mymealmonkey.utils

import java.util.Calendar

val calendar: Calendar = Calendar.getInstance()

//Check Email Validation
fun String.isNotValidEmail(): Boolean {
    return (!(android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()))
}

//Check Password Validation
fun String.isNotValidPassword(): Boolean {
    return (this.length < 7)
}

//Check any Input Validation
fun String.isNotValidInput(): Boolean {
    return (this.trim().isEmpty())
}

//Check Mobile Number Validation
fun String.isNotValidMobileNumber(): Boolean {
    return (this.trim().isEmpty() || this.length > 10)
}

//Check Card Month Validation
fun String.isNotValidCardMonth(): Boolean {
    return ((this.toIntOrNull() ?: 0) > 12 || (this.toIntOrNull() ?: 0) < 1)
}

//Check Card Year Validation
fun String.isNotValidCardYear(): Boolean {
    return (this.toIntOrNull() ?: 0) < calendar.get(Calendar.YEAR)
}

//Check Card Number Validation
fun String.isNotValidCardNumber(): Boolean {
    return ((this.length) != 16)
}