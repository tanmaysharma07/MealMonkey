package com.example.mymealmonkey.view.fragment.dessertFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentDessertBinding

class DessertFragment : Fragment() {

    lateinit var binding: FragmentDessertBinding
    val viewModel: DessertFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDessertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dessertFragmentArray = ArrayList<DessertFragmentData>()
        dessertFragmentArray.addAll(
            arrayOf(
                DessertFragmentData(
                    R.drawable.dessert1,
                    getString(R.string.caf_western_food),
                    getString(R.string.caf_de_noir),
                    getString(R.string.desserts)
                ),
                DessertFragmentData(
                    R.drawable.dessert2,
                    getString(R.string.caf_western_food),
                    getString(R.string.bakes_by_tella),
                    getString(R.string.desserts)
                ),
                DessertFragmentData(
                    R.drawable.dessert3,
                    getString(R.string.caf_western_food),
                    getString(R.string.caf_de_bambaa),
                    getString(R.string.desserts)
                ),
                DessertFragmentData(
                    R.drawable.dessert4,
                    getString(R.string.caf_western_food),
                    getString(R.string.minute_by_tuk_tuk),
                    getString(R.string.desserts)
                )
            )
        )

        // Initialized RecyclerView
        val dessertFragmentAdapter = DessertFragmentAdapter(dessertFragmentArray)
        binding.recyclerViewDessertFragment.adapter = dessertFragmentAdapter.apply {
            setOnItemClickListener(object : DessertFragmentAdapter.ItemClickListener {
                override fun itemClick(position: Int) {
                    findNavController().navigate(R.id.orderFragment)
                }
            })
        }
        binding.recyclerViewDessertFragment.hasFixedSize()
    }
}