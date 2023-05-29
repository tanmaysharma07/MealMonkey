package com.example.mymealmonkey.view.fragment.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentHomePageBinding
import com.example.mymealmonkey.view.fragment.homepage.adapter.CountryFoodHomeAdapter
import com.example.mymealmonkey.view.fragment.homepage.adapter.MostPopularHomeAdapter
import com.example.mymealmonkey.view.fragment.homepage.adapter.PopularRestaurantHomeAdapter
import com.example.mymealmonkey.view.fragment.homepage.adapter.RecentItemsHomeAdapter
import com.example.mymealmonkey.view.fragment.homepage.data.CountryFoodHomeData
import com.example.mymealmonkey.view.fragment.homepage.data.MostPopularHomeData
import com.example.mymealmonkey.view.fragment.homepage.data.PopularRestaurantHomeData
import com.example.mymealmonkey.view.fragment.homepage.data.RecentItemsHomeData
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomePageFragment : Fragment() {

    private val viewModel: HomePageViewModel by viewModels()
    private lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countryFoodHomeArray = ArrayList<CountryFoodHomeData>()
        countryFoodHomeArray.addAll(
            arrayOf(
                CountryFoodHomeData(getString(R.string.offers), R.drawable.burger2),
                CountryFoodHomeData(getString(R.string.indian), R.drawable.indian),
                CountryFoodHomeData(getString(R.string.italian), R.drawable.italian),
                CountryFoodHomeData(getString(R.string.sri_lankan), R.drawable.shri_lankan),
                CountryFoodHomeData(getString(R.string.indian), R.drawable.indian),
                CountryFoodHomeData(getString(R.string.italian), R.drawable.italian),
                CountryFoodHomeData(getString(R.string.sri_lankan), R.drawable.shri_lankan),
            )
        )

        val mostPopularHomeArray = ArrayList<MostPopularHomeData>()
        mostPopularHomeArray.addAll(
            arrayOf(
                MostPopularHomeData(
                    R.drawable.pizza1,
                    (R.string.caf_de_bambaa),
                    R.string.caf_western_food
                ),
                MostPopularHomeData(
                    R.drawable.dish1,
                    R.string.burger_by_bella,
                    R.string.caf_western_food
                ),
                MostPopularHomeData(
                    R.drawable.pizza1,
                    R.string.caf_de_bambaa,
                    R.string.caf_western_food
                ),
                MostPopularHomeData(
                    R.drawable.dish1,
                    R.string.burger_by_bella,
                    R.string.caf_western_food
                ),
            )
        )

        val popularHomeArray = ArrayList<PopularRestaurantHomeData>()
        popularHomeArray.addAll(
            arrayOf(
                PopularRestaurantHomeData(
                    R.drawable.pizza2,
                    R.string.minute_by_tuk_tuk,
                    R.string._124_ratings_caf
                ),
                PopularRestaurantHomeData(
                    R.drawable.dessert1,
                    R.string.caf_de_noir,
                    R.string._124_ratings_caf
                ),
                PopularRestaurantHomeData(
                    R.drawable.burger4,
                    R.string.bakes_by_tella,
                    R.string._124_ratings_caf
                )
            )
        )

        val recentItemsHomeArray = ArrayList<RecentItemsHomeData>()
        recentItemsHomeArray.addAll(
            arrayOf(
                RecentItemsHomeData(
                    R.drawable.pizza3,
                    R.string.mulberry_pizza_by_josh,
                    R.string.caf_western_food
                ),
                RecentItemsHomeData(
                    R.drawable.coffee1,
                    R.string.barita,
                    R.string.caf_western_food
                ),
                RecentItemsHomeData(
                    R.drawable.pizza1,
                    R.string.pizza_rush_hour,
                    R.string.caf_western_food
                )
            )
        )

        initialize()

        setListeners()

        bindObservers()

        val recyclerViewCountryFood = binding.recyclerViewCountryFood
        recyclerViewCountryFood.adapter = CountryFoodHomeAdapter(countryFoodHomeArray).apply {
            setOnItemClickListener(object : CountryFoodHomeAdapter.ItemClickListener {
                override fun itemClick(position: Int) {
                    val bundle = Bundle()
                    bundle.putString("countryFood", Gson().toJson(countryFoodHomeArray[position]))
                    findNavController().navigate(R.id.orderFragment, bundle)
                    //Toast.makeText(requireContext(), "$position", Toast.LENGTH_SHORT).show()
                }
            })
        }
        recyclerViewCountryFood.setHasFixedSize(true)

        val popularRestaurantHomeAdapter = PopularRestaurantHomeAdapter(this, popularHomeArray)
        binding.recyclerViewPopular.adapter = popularRestaurantHomeAdapter.apply {
            setOnItemClickListener(object : PopularRestaurantHomeAdapter.ItemClickListener {
                override fun itemClick(position: Int) {
                    findNavController().navigate(R.id.orderFragment)
                }
            })
        }
        binding.recyclerViewPopular.setHasFixedSize(true)

        val mostPopularHomeAdapter = MostPopularHomeAdapter(this, mostPopularHomeArray)
        binding.recyclerViewMostPopular.adapter = mostPopularHomeAdapter.apply {
            setOnItemClickListener(object : MostPopularHomeAdapter.ItemClickListener {
                override fun itemClick(position: Int) {
                    findNavController().navigate(R.id.orderFragment)
                }
            })
        }
        binding.recyclerViewMostPopular.setHasFixedSize(true)

        val recentItemsHomeAdapter = RecentItemsHomeAdapter(this, recentItemsHomeArray)
        binding.recyclerViewRecent.adapter = recentItemsHomeAdapter.apply {
            setOnItemClickListener(object : RecentItemsHomeAdapter.ItemClickListener {
                override fun itemClick(position: Int) {
                    findNavController().navigate(R.id.orderFragment)
                }
            })
        }
        binding.recyclerViewRecent.setHasFixedSize(true)

    }

    private fun bindObservers() {

    }

    private fun setListeners() {

    }

    private fun initialize() {

    }

}