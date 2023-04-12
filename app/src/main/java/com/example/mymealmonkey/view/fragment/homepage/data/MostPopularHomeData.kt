package com.example.mymealmonkey.view.fragment.homepage.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MostPopularHomeData(
    @DrawableRes val imageResourceId:Int,
    @StringRes val nameResourceId:Int,
    @StringRes val typeResourceId:Int
)