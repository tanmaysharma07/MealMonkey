package com.example.mymealmonkey.view.fragment.latestOffers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymealmonkey.databinding.FragmentLatestActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LatestOffersPageFragment : Fragment() {

    private  val viewModel: LatestOffersViewModel by viewModels()
    private lateinit var binding:FragmentLatestActivityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLatestActivityBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()

        setListeners()

        bindObservers()

        val myDatasetLatestOffers = LatestOffersDatasource().loadLatestOffers()
        val recyclerViewLatestOffer = binding.recyclerViewLatestOffers
        recyclerViewLatestOffer.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewLatestOffer.adapter = LatestOfferAdapter(this, myDatasetLatestOffers)
        recyclerViewLatestOffer.setHasFixedSize(true)
    }

    private fun bindObservers() {

    }

    private fun initialize() {

    }

    private fun setListeners() {

    }
}