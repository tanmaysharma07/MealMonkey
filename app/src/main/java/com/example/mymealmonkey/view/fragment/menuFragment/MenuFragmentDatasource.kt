package com.example.mymealmonkey.view.fragment.menuFragment

import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.dessertFragment.DessertFragmentData

class MenuFragmentDatasource {
    fun loadMenu():List<MenuFragmentData>{
        return listOf(
            MenuFragmentData(R.drawable.burger2),
            MenuFragmentData(R.drawable.burger2),
            MenuFragmentData(R.drawable.burger2),
            MenuFragmentData(R.drawable.burger2)
        )
    }
}