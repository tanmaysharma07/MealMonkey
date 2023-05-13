package com.example.mymealmonkey.view.fragment.latestOffers

import com.example.mymealmonkey.R

class LatestOffersDatasource {
    fun loadLatestOffers(): List<LatestOffersData> {
        return listOf<LatestOffersData>(
            LatestOffersData(
                R.drawable.burger2,
                R.string.minute_by_tuk_tuk,
                R.string._124_ratings_caf
            ),
            LatestOffersData(
                R.drawable.burger2,
                R.string.minute_by_tuk_tuk,
                R.string._124_ratings_caf
            ),
            LatestOffersData(
                R.drawable.burger2,
                R.string.minute_by_tuk_tuk,
                R.string._124_ratings_caf
            )
        )
    }
}