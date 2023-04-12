package com.example.mymealmonkey.view.fragment.homepage.data

import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

data class ParentHomeData(
    @StringRes val title:Int,
    @StringRes val viewAll:Int,
    val recyclerViews: List<MostPopularHomeData>
)
