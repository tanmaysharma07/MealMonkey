package com.example.mymealmonkey.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.AddCardDetailsData
import com.example.mymealmonkey.databinding.FragmentAddCardBottomSheetBinding
import com.example.mymealmonkey.utils.AddCardBottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson

class AddCardBottomSheetFragment(private val addCardBottomSheet: AddCardBottomSheet) :
    BottomSheetDialogFragment() {

    // Initialize ViewModel
    val viewModel: AddCardBottomSheetVM by viewModels()

    //Binding Component
    lateinit var binding: FragmentAddCardBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Data Binding
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_card_bottom_sheet,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Click Listener
        clickListeners()
    }

    //Set Click Listener
    private fun clickListeners() {
        binding.addCard.setOnClickListener {

            // Check Card Number validity
            if (viewModel.isCardNumberValid()) {
                binding.cardNumber.helperText = getString(R.string.invalid_card_number)
                return@setOnClickListener
            }
            binding.cardNumber.helperText = null

            // Check Card Month validity
            if (viewModel.isCardMonthValid()) {
                binding.cardMonth.helperText = getString(R.string.invalid_month)
                return@setOnClickListener
            }
            binding.cardMonth.helperText = null

            // Check Card Year validity
            if (viewModel.isCardYearValid()) {
                binding.cardYear.helperText = getString(R.string.invalid_year)
                return@setOnClickListener
            }
            binding.cardYear.helperText = null

            // Check Card Security Code validity
            if (viewModel.isSecurityCodeValid()) {
                binding.cardSecurityCode.helperText = getString(R.string.invalid_code)
                return@setOnClickListener
            }
            binding.cardSecurityCode.helperText = null

            // Check First Name validity
            if (viewModel.isFirstNameValid()) {
                binding.cardFirstName.helperText = getString(R.string.enter_first_name)
                return@setOnClickListener
            }
            binding.cardFirstName.helperText = null

            // Check Last Number validity
            if (viewModel.isLastNameValid()) {
                binding.cardLastName.helperText = getString(R.string.enter_last_name)
                return@setOnClickListener
            }
            binding.cardLastName.helperText = null

            val addCardDetailsData = AddCardDetailsData(
                viewModel.cardNumber.get().toString(),
                viewModel.cardMonth.get().toString(),
                viewModel.cardYear.get().toString(),
                viewModel.cardSecurityCode.get().toString(),
                viewModel.cardFirstName.get().toString(),
                viewModel.cardLastName.get().toString(),
            )

            // Bundle Data to another fragment
            val bundle = Bundle()
            bundle.putString(
                getString(R.string.addcarddetailsdata),
                Gson().toJson(addCardDetailsData)
            )
            addCardBottomSheet.refreshRecyclerView(bundle)
            dismissAllowingStateLoss()
        }

        // Dismiss the fragment
        binding.notificationBottomSheetClose.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }
}