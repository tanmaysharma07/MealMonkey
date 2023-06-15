package com.example.mymealmonkey.view.fragment.dessertFragment

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DessertFragmentData(
    @DrawableRes val imageResourceId: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val typeResourceId: Int,
    @StringRes val madeResourceId: Int
) {
}