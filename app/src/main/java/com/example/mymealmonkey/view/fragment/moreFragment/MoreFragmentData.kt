package com.example.mymealmonkey.view.fragment.moreFragment

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MoreFragmentData(
    @DrawableRes val ImageID: Int,
    @StringRes val titleID: Int,
    val navigateID: Int
) {
}