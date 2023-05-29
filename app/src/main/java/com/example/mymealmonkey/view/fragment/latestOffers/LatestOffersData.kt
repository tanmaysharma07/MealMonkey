package com.example.mymealmonkey.view.fragment.latestOffers

import androidx.annotation.DrawableRes

data class LatestOffersData(
    @DrawableRes val imageResourceId: Int,
    val nameResourceId: String,
    val ratingResourceId: String
)