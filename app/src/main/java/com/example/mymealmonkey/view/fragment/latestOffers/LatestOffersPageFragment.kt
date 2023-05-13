package com.example.mymealmonkey.view.fragment.latestOffers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentLatestActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LatestOffersPageFragment : Fragment() {

    private val viewModel: LatestOffersViewModel by viewModels()
    private lateinit var binding: FragmentLatestActivityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLatestActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialized RecyclerView
        val myDatasetLatestOffers = LatestOffersDatasource().loadLatestOffers()
        binding.recyclerViewLatestOffers.adapter = LatestOfferAdapter(this, myDatasetLatestOffers)
        binding.recyclerViewLatestOffers.setHasFixedSize(true)
    }
}