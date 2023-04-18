package com.example.mymealmonkey.view.fragment.dessertFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentDessertBinding

class DessertFragment : Fragment() {

    lateinit var binding:FragmentDessertBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDessertBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dessertDataset = DessertFragmentDatasource().loadDesserts()
        binding.recyclerViewDessertFragment.adapter = DessertFragmentAdapter(this,dessertDataset)
        binding.recyclerViewDessertFragment.hasFixedSize()
    }
}