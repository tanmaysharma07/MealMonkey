package com.example.mymealmonkey.view.fragment.latestOffers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.databinding.FragmentLatestActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LatestOffersPageFragment : Fragment() {

    private  val latestOffersViewModel: LatestOffersViewModel by viewModels()
    private lateinit var binding:FragmentLatestActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        latestOffersViewModel.eventListener.checkable.postValue("Offers")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLatestActivityBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        latestOffersViewModel.eventListener.showBottomNavigation()
        latestOffersViewModel.eventListener.fabColor.postValue("Grey")

        val myDatasetLatestOffers = LatestOffersDatasource().loadLatestOffers()
        val recyclerViewLatestOffer = binding.recyclerViewLatestOffers
        recyclerViewLatestOffer.adapter = LatestOfferAdapter(this, myDatasetLatestOffers)
        recyclerViewLatestOffer.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        latestOffersViewModel.eventListener.checkable.postValue("Offers")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        latestOffersViewModel.eventListener.checkable.postValue("")
    }
}