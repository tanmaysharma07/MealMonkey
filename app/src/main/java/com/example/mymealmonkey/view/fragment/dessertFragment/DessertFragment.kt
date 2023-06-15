package com.example.mymealmonkey.view.fragment.dessertFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.OrderDetailData
import com.example.mymealmonkey.databinding.FragmentDessertBinding
import com.example.mymealmonkey.utils.BaseItemClickListener
import com.google.gson.Gson

class DessertFragment : Fragment() {

    //Binding Component
    lateinit var binding: FragmentDessertBinding

    //ViewModel Initialization
    val viewModel: DessertFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View Binding
        binding = FragmentDessertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Array to Store the Data for Dessert Fragment
        val dessertFragmentArray = ArrayList<DessertFragmentData>()
        dessertFragmentArray.addAll(
            arrayOf(
                DessertFragmentData(
                    R.drawable.dessert1,
                    (R.string.caf_western_food),
                    (R.string.caf_de_noir),
                    (R.string.desserts)
                ),
                DessertFragmentData(
                    R.drawable.dessert2,
                    (R.string.caf_western_food),
                    (R.string.bakes_by_tella),
                    (R.string.desserts)
                ),
                DessertFragmentData(
                    R.drawable.dessert3,
                    (R.string.caf_western_food),
                    (R.string.caf_de_bambaa),
                    (R.string.desserts)
                ),
                DessertFragmentData(
                    R.drawable.dessert4,
                    (R.string.caf_western_food),
                    (R.string.minute_by_tuk_tuk),
                    (R.string.desserts)
                )
            )
        )

        // Initialized RecyclerView
        val dessertFragmentAdapter = DessertFragmentAdapter(dessertFragmentArray)
        binding.recyclerViewDessertFragment.adapter = dessertFragmentAdapter.apply {
            setOnItemClickListener(object : BaseItemClickListener {
                override fun itemClick(position: Int) {
                    val bundle = Bundle()
                    val orderDetailData = OrderDetailData(
                        dessertFragmentArray[position].imageResourceId,
                        dessertFragmentArray[position].nameResourceId
                    )
                    bundle.putString(
                        getString(R.string.orderdetails),
                        Gson().toJson(orderDetailData)
                    )
                    findNavController().navigate(R.id.orderFragment, bundle)
                }
            })
        }
        binding.recyclerViewDessertFragment.hasFixedSize()

        // Bundle Opened
        val jsonDessertFragment = arguments?.getString(getString(R.string.pagetitle))
        if (jsonDessertFragment != null) {
            binding.desserts.text = jsonDessertFragment
        }

    }
}