package com.example.mymealmonkey.view.fragment.dessertFragment

import androidx.annotation.DrawableRes

data class DessertFragmentData(
    @DrawableRes val imageId: Int,
    val dishId: String,
    val typeId: String,
    val madeId: String
) {
}