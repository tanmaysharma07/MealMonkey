package com.example.mymealmonkey.view.fragment.myOrder

import com.example.mymealmonkey.R

class MyOrderFragmentDatasource {
    fun loadMyOrder(): List<MyOrderFragmentData> {
        return listOf<MyOrderFragmentData>(
            MyOrderFragmentData(R.string.veg_burger, "1", R.string._16),
            MyOrderFragmentData(R.string.veg_burger, "1", R.string._16),
            MyOrderFragmentData(R.string.veg_burger, "1", R.string._16),
            MyOrderFragmentData(R.string.veg_burger, "1", R.string._16),
            MyOrderFragmentData(R.string.veg_burger, "1", R.string._16)
        )
    }
}