package com.example.mymealmonkey.view.fragment.menuFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    //ViewModel Initialized
    private val viewModel: MenuFragmentViewModel by viewModels()

    //Binding Component
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Click Listeners
        clickListeners()
    }

    /**
     * Set Click Listeners
     */
    private fun clickListeners() {
        binding.foodMenu.setOnClickListener {
            //Navigate to Dessert Page in Menu
            findNavController().navigate(R.id.action_menuFragment_to_dessertFragment)
        }
        binding.beveragesMenu.setOnClickListener {
            //Navigate to Dessert Page in Menu
            findNavController().navigate(R.id.action_menuFragment_to_dessertFragment)
        }
        binding.dessertsMenu.setOnClickListener {
            //Navigate to Dessert Page in Menu
            findNavController().navigate(R.id.action_menuFragment_to_dessertFragment)
        }
        binding.promotionsMenu.setOnClickListener {
            //Navigate to Dessert Page in Menu
            findNavController().navigate(R.id.action_menuFragment_to_dessertFragment)
        }
    }
}