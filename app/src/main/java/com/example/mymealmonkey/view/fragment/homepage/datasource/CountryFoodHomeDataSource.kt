package com.example.mymealmonkey.view.fragment.homepage.datasource

import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.data.CountryFoodHomeData

class CountryFoodHomeDataSource {

    fun loadImages(): List<CountryFoodHomeData> {
        return listOf<CountryFoodHomeData>(
            CountryFoodHomeData(R.string.offers, R.drawable.burger2),
            CountryFoodHomeData(R.string.indian, R.drawable.burger2),
            CountryFoodHomeData(R.string.italian, R.drawable.burger2),
            CountryFoodHomeData(R.string.sri_lankan, R.drawable.burger2),
            CountryFoodHomeData(R.string.indian, R.drawable.burger2),
            CountryFoodHomeData(R.string.italian, R.drawable.burger2),
            CountryFoodHomeData(R.string.offers, R.drawable.burger2),
            CountryFoodHomeData(R.string.indian, R.drawable.burger2),
            CountryFoodHomeData(R.string.italian, R.drawable.burger2),
            CountryFoodHomeData(R.string.sri_lankan, R.drawable.burger2),
            CountryFoodHomeData(R.string.indian, R.drawable.burger2),
            CountryFoodHomeData(R.string.italian, R.drawable.burger2)

        )
    }
}