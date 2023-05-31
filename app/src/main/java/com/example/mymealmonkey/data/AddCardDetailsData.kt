package com.example.mymealmonkey.data


import com.google.errorprone.annotations.Keep

@Keep
data class AddCardDetailsData(
    val cardNumber: String?,
    val cardMonth: String?,
    val cardYear: String?,
    val securityCode: String?,
    val firstName: String?,
    val lastName: String?,
)
