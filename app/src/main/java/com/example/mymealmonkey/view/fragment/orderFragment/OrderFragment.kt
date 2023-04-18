package com.example.mymealmonkey.view.fragment.orderFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentDessertBinding
import com.example.mymealmonkey.databinding.FragmentOrderBinding
import com.google.android.material.textfield.TextInputLayout

class OrderFragment : Fragment() {

    lateinit var binding: FragmentOrderBinding
    private val viewModel:OrderFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_order,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textField = binding.sizePotionTextfield
        val textField2 = binding.selectIngredientsTextfield

        val items = listOf("Size1", "Size2", "Size3", "Size4")
        val adapter = ArrayAdapter(requireContext(), R.layout.size_portion_list_item, items)
        (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        (textField2.editText as? AutoCompleteTextView)?.setAdapter(adapter)

    }
}