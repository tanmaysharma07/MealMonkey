package com.example.mymealmonkey.view.fragment.dessertFragment

import com.example.mymealmonkey.R

class DessertFragmentDatasource {
    fun loadDesserts():List<DessertFragmentData>{
        return listOf<DessertFragmentData>(
            DessertFragmentData(R.drawable.burger2,R.string.caf_western_food,R.string._4_9_124_ratings_caf_western_food),
            DessertFragmentData(R.drawable.burger2,R.string.caf_western_food,R.string._4_9_124_ratings_caf_western_food),
            DessertFragmentData(R.drawable.burger2,R.string.caf_western_food,R.string._4_9_124_ratings_caf_western_food),
            DessertFragmentData(R.drawable.burger2,R.string.caf_western_food,R.string._4_9_124_ratings_caf_western_food)
        )
    }
}