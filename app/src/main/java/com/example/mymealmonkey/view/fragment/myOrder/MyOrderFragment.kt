package com.example.mymealmonkey.view.fragment.myOrder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentMyOrderBinding

class MyOrderFragment : Fragment() {

    // Initializing ViewModel
    val viewModel: MyOrderFragmentViewModel by viewModels()

    // Binding Component
    lateinit var binding: FragmentMyOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View Binding
        binding = FragmentMyOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myOrderArray = ArrayList<MyOrderFragmentData>()
        myOrderArray.addAll(
            arrayOf(
                MyOrderFragmentData(R.string.veg_burger, R.string._1, R.string._16),
                MyOrderFragmentData(R.string.veg_pizza, R.string._1, R.string._14),
                MyOrderFragmentData(R.string.cheese_burger, R.string._1, R.string._17),
                MyOrderFragmentData(R.string.fries, R.string._1, R.string._15),
                MyOrderFragmentData(R.string.coffee, R.string._1, R.string._6)
            )
        )

        // Initialized RecyclerView
        binding.myOrderRecyclerView.adapter = MyOrderFragmentAdapter(myOrderArray)
        binding.myOrderRecyclerView.hasFixedSize()

        // Set Click Listeners
        clickListener()

    }

    // Set Click Listeners
    private fun clickListener() {
        binding.myOrderBackArrow.setOnClickListener {
            //Navigate to Previous Fragment
            findNavController().navigateUp()
        }
        binding.checkoutButtonMyOrder.setOnClickListener {
            //Navigate to Checkout Fragment
            findNavController().navigate(R.id.action_myOrderFragment_to_checkoutFragment)
        }
    }
}