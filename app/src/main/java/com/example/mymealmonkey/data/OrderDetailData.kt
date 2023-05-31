package com.example.mymealmonkey.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OrderDetailData(
    @DrawableRes val imageResourceId:Int? = null,
    @StringRes val nameResourceId:Int? = null,
)
