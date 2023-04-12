package com.example.mymealmonkey.view.fragment.latestOffers

import com.example.mymealmonkey.R

class LatestOffersDatasource{
    fun loadLatestOffers(): List<LatestOffersData> {
        return listOf<LatestOffersData>(
            LatestOffersData( R.drawable.burger2,R.string.minute_by_tuk_tuk,R.string._4_9_124_ratings_caf_western_food),
            LatestOffersData( R.drawable.burger2,R.string.minute_by_tuk_tuk,R.string._4_9_124_ratings_caf_western_food),
            LatestOffersData( R.drawable.burger2,R.string.minute_by_tuk_tuk,R.string._4_9_124_ratings_caf_western_food)
            )
    }
}