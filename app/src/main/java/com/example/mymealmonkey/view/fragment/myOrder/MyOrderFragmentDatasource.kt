package com.example.mymealmonkey.view.fragment.myOrder

import com.example.mymealmonkey.R

class MyOrderFragmentDatasource {
    fun loadMyOrder(): List<MyOrderFragmentData> {
        return listOf<MyOrderFragmentData>(
            MyOrderFragmentData(R.string.veg_burger, "1", R.string._16),
            MyOrderFragmentData(R.string.veg_pizza, "1", R.string._14),
            MyOrderFragmentData(R.string.cheese_burger, "1", R.string._17),
            MyOrderFragmentData(R.string.fries, "1", R.string._15),
            MyOrderFragmentData(R.string.coffee, "1", R.string._6)
        )
    }
}