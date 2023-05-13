package com.example.mymealmonkey.view.fragment.dessertFragment

import com.example.mymealmonkey.R

class DessertFragmentDatasource {
    fun loadDesserts(): List<DessertFragmentData> {
        return listOf<DessertFragmentData>(
            DessertFragmentData(
                R.drawable.burger2,
                R.string.caf_western_food,
                R.string.minute_by_tuk_tuk,
                R.string.desserts
            ),
            DessertFragmentData(
                R.drawable.burger2,
                R.string.caf_western_food,
                R.string.minute_by_tuk_tuk,
                R.string.desserts
            ),
            DessertFragmentData(
                R.drawable.burger2,
                R.string.caf_western_food,
                R.string.minute_by_tuk_tuk,
                R.string.desserts
            ),
            DessertFragmentData(
                R.drawable.burger2,
                R.string.caf_western_food,
                R.string.minute_by_tuk_tuk,
                R.string.desserts
            )
        )
    }
}