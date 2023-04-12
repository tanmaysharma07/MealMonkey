package com.example.mymealmonkey.view.fragment.homepage.datasource

import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.data.RecentItemsHomeData

class RecentItemsHomeDatasource() {
    fun loadRecentItems():List<RecentItemsHomeData> {
        return listOf(
            RecentItemsHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food),
            RecentItemsHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food),
            RecentItemsHomeData(R.drawable.burger2,R.string.caf_de_bambaa,R.string.caf_western_food)
        )
    }
}