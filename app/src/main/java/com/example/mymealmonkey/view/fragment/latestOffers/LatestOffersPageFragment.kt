package com.example.mymealmonkey.view.fragment.latestOffers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.OrderDetailData
import com.example.mymealmonkey.databinding.FragmentLatestOffersBinding
import com.example.mymealmonkey.utils.BaseItemClickListener
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LatestOffersPageFragment : Fragment() {

    //ViewModel Initialization
    private val viewModel: LatestOffersViewModel by viewModels()

    //Binding Component
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
                    (R.string.caf_de_noir),
                    (R.string._124_ratings_caf)
                ),
                LatestOffersData(
                    R.drawable.pizza2,
                    (R.string.caf_western_food),
                    (R.string._124_ratings_caf)
                ),
                LatestOffersData(
                    R.drawable.coffee2,
                    (R.string.cafe_beans),
                    (R.string._124_ratings_caf)
                )
            )
        )

        //Initialized RecyclerView
        val latestOfferAdapter = LatestOfferAdapter(latestOffersArray)
        binding.recyclerViewLatestOffers.adapter = latestOfferAdapter.apply {
            setOnItemClickListener(object : BaseItemClickListener {
                override fun itemClick(position: Int) {
                    val bundle = Bundle()
                    val orderDetailData = OrderDetailData(
                        latestOffersArray[position].imageResourceId,
                        latestOffersArray[position].nameResourceId
                    )
                    bundle.putString(
                        getString(R.string.orderdetails),
                        Gson().toJson(orderDetailData)
                    )
                    findNavController().navigate(R.id.orderFragment, bundle)
                }
            })
        }
        binding.recyclerViewLatestOffers.setHasFixedSize(true)
    }
}