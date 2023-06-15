package com.example.mymealmonkey.view.fragment.orderFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.OrderDetailData
import com.example.mymealmonkey.databinding.FragmentOrderBinding
import com.google.gson.Gson

class OrderFragment : Fragment() {

    // Binding Component
    lateinit var binding: FragmentOrderBinding

    // Initialized ViewModel
    private val viewModel: OrderFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the data when started
        setInitialData()

        // Items List in Scroll Down List
        val items = listOf(
            getString(R.string.size1),
            getString(R.string.size2),
            getString(R.string.size3),
            getString(R.string.size4)
        )

        // Initializing the Scroll Down Lists
        val adapter = ArrayAdapter(requireContext(), R.layout.drop_down_list_item, items)

        // Select Size Portion
        binding.sizePortionAutoComplete.setAdapter(adapter)
        binding.sizePortionAutoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, itemPosition, _ ->
                val sizeSelected = adapterView.getItemAtPosition(itemPosition)

                Toast.makeText(requireContext(), "Selected Size: $sizeSelected", Toast.LENGTH_SHORT)
                    .show()
            }

        //Select Ingredient
        binding.selectIngredientAutoComplete.setAdapter(adapter)
        binding.selectIngredientAutoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, itemPosition, _ ->
                val ingredientSelected = adapterView.getItemAtPosition(itemPosition)

                Toast.makeText(
                    requireContext(),
                    "Selected Size: $ingredientSelected",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    // Set Initial Data if required
    private fun setInitialData() {
        val jsonCountryFoodHome = arguments?.getString(getString(R.string.orderdetails))
        if (jsonCountryFoodHome != null) {
            val countryFoodHome = Gson().fromJson(
                jsonCountryFoodHome,
                OrderDetailData::class.java
            )
            countryFoodHome?.let {
                binding.tandooriPizza.setText(it.nameResourceId ?: 0)
                binding.orderImage.setImageResource(it.imageResourceId ?: 0)
            }
        }
    }
}