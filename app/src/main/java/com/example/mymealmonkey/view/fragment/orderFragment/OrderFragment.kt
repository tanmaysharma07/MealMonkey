package com.example.mymealmonkey.view.fragment.orderFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentDessertBinding
import com.example.mymealmonkey.databinding.FragmentOrderBinding
import com.google.android.material.textfield.TextInputLayout

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

        // Items List in Scroll Down List
        val items = listOf("Size1", "Size2", "Size3", "Size4")

        // Initializing the Scroll Down Lists
        val adapter = ArrayAdapter(requireContext(), R.layout.size_portion_list_item, items)
        (binding.sizePotionTextfield.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        (binding.selectIngredientsTextfield.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        // When User ChangeTextInput Directly
        binding.portionCountTextInput.doAfterTextChanged {
            viewModel.total()
        }
    }
}