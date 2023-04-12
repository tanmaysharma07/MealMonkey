package com.example.mymealmonkey.view.fragment.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentHomePageBinding
import com.example.mymealmonkey.view.fragment.homepage.adapter.CountryFoodHomeAdapter
import com.example.mymealmonkey.view.fragment.homepage.adapter.MostPopularHomeAdapter
import com.example.mymealmonkey.view.fragment.homepage.adapter.PopularRestaurantHomeAdapter
import com.example.mymealmonkey.view.fragment.homepage.adapter.RecentItemsHomeAdapter
import com.example.mymealmonkey.view.fragment.homepage.datasource.CountryFoodHomeDataSource
import com.example.mymealmonkey.view.fragment.homepage.datasource.MostPopularHomeDatasource
import com.example.mymealmonkey.view.fragment.homepage.datasource.PopularRestaurantHomedataSource
import com.example.mymealmonkey.view.fragment.homepage.datasource.RecentItemsHomeDatasource
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomePageFragment : Fragment() {

    private val homePageViewModel: HomePageViewModel by viewModels()
    private lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePageViewModel.eventListener.showBottomNavigation.postValue(true)


        val myDatasetCountryFood = CountryFoodHomeDataSource().loadImages()
        val recyclerViewCountryFood = binding.recyclerViewCountryFood
        recyclerViewCountryFood.adapter = CountryFoodHomeAdapter(this, myDatasetCountryFood)
        recyclerViewCountryFood.setHasFixedSize(true)


        val myDatasetPopularRestaurant = PopularRestaurantHomedataSource().loadPopularHome()
        val recyclerViewPopular = binding.recyclerViewPopular
        recyclerViewPopular.adapter = PopularRestaurantHomeAdapter(this, myDatasetPopularRestaurant)
        recyclerViewPopular.setHasFixedSize(true)


        val myDatasetMostPopular = MostPopularHomeDatasource().loadMostPopular()
        val recyclerViewMostPopular = binding.recyclerViewMostPopular
        recyclerViewMostPopular.adapter = MostPopularHomeAdapter(this, myDatasetMostPopular)
        recyclerViewMostPopular.setHasFixedSize(true)


        val myDatasetRecentItems = RecentItemsHomeDatasource().loadRecentItems()
        val recyclerViewRecentItems = binding.recyclerViewRecent
        recyclerViewRecentItems.adapter = RecentItemsHomeAdapter(this, myDatasetRecentItems)
        recyclerViewRecentItems.setHasFixedSize(true)

    }

}