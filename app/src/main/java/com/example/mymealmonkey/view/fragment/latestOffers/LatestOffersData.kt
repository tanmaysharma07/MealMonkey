package com.example.mymealmonkey.view.fragment.latestOffers

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LatestOffersData(
    @DrawableRes val imageResourceId: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val ratingResourceId: Int
)