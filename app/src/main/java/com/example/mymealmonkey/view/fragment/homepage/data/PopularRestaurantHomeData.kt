package com.example.mymealmonkey.view.fragment.homepage.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PopularRestaurantHomeData(
    @DrawableRes val imageResourceId:Int,
    @StringRes val nameResourceId:Int,
    @StringRes val ratingResourceId:Int
)