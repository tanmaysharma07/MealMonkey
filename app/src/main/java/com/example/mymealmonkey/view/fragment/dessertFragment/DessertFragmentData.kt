package com.example.mymealmonkey.view.fragment.dessertFragment

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DessertFragmentData(
    @DrawableRes val imageId:Int,
    @StringRes val dishId:Int,
    @StringRes val ratingId:Int
) {
}