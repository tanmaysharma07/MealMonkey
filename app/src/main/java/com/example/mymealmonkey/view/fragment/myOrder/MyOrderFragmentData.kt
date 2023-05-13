package com.example.mymealmonkey.view.fragment.myOrder


import androidx.annotation.StringRes

data class MyOrderFragmentData(
    @StringRes val titleID: Int,
    val countID: String,
    @StringRes val priceID: Int
)