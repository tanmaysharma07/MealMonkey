package com.example.mymealmonkey.view.fragment.homepage.datasource

import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.data.MostPopularHomeData

class MostPopularHomeDatasource {
    fun loadMostPopular():List<MostPopularHomeData> {
        return listOf(
            MostPopularHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food),
            MostPopularHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food),
            MostPopularHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food),
            MostPopularHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food),
            MostPopularHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food),
            MostPopularHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food)
        )
    }
}