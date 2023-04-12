package com.example.mymealmonkey.view.fragment.homepage.datasource

import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.data.PopularRestaurantHomeData

class PopularRestaurantHomeDatasource{
    fun loadPopularHome(): List<PopularRestaurantHomeData> {
        return listOf<PopularRestaurantHomeData>(
            PopularRestaurantHomeData( R.drawable.burger2,R.string.minute_by_tuk_tuk,R.string._4_9_124_ratings_caf_western_food),
            PopularRestaurantHomeData( R.drawable.burger2,R.string.minute_by_tuk_tuk,R.string._4_9_124_ratings_caf_western_food),
            PopularRestaurantHomeData( R.drawable.burger2,R.string.minute_by_tuk_tuk,R.string._4_9_124_ratings_caf_western_food)
            )
    }
}