package com.example.mymealmonkey.view.fragment.latestOffers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentLatestOffersBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LatestOffersPageFragment : Fragment() {

    private val viewModel: LatestOffersViewModel by viewModels()
    private lateinit var binding: FragmentLatestOffersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLatestOffersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Array contain data  of Latest Offer recyclerview
        val latestOffersArray = ArrayList<LatestOffersData>()
        latestOffersArray.addAll(
            listOf<LatestOffersData>(
                LatestOffersData(
                    R.drawable.dessert1,
                    getString(R.string.caf_de_noir),
                    getString(R.string._124_ratings_caf)
                ),
                LatestOffersData(
                    R.drawable.pizza2,
                    getString(R.string.caf_western_food),
                    getString(R.string._124_ratings_caf)
                ),
                LatestOffersData(
                    R.drawable.coffee2,
                    getString(R.string.cafe_beans),
                    getString(R.string._124_ratings_caf)
                )
            )
        )

        //Initialized RecyclerView
        val latestOfferAdapter = LatestOfferAdapter(this, latestOffersArray)
        binding.recyclerViewLatestOffers.adapter = latestOfferAdapter.apply {
            setOnItemClickListener(object : LatestOfferAdapter.ItemClickListener {
                override fun itemClick(position: Int) {
                    findNavController().navigate(R.id.orderFragment)
                }
            })
        }
        binding.recyclerViewLatestOffers.setHasFixedSize(true)
    }
}