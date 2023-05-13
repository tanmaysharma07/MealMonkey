package com.example.mymealmonkey.view.fragment.homepage.datasource

import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.data.PopularRestaurantHomeData

// Data For Recycler View
class PopularRestaurantHomeDatasource {
    fun loadPopularHome(): List<PopularRestaurantHomeData> {
        return listOf<PopularRestaurantHomeData>(
            PopularRestaurantHomeData(
                R.drawable.burger2,
                R.string.minute_by_tuk_tuk,
                R.string._124_ratings_caf
            ),
            PopularRestaurantHomeData(
                R.drawable.burger2,
                R.string.minute_by_tuk_tuk,
                R.string._124_ratings_caf
            ),
            PopularRestaurantHomeData(
                R.drawable.burger2,
                R.string.minute_by_tuk_tuk,
                R.string._124_ratings_caf
            )
        )
    }
}