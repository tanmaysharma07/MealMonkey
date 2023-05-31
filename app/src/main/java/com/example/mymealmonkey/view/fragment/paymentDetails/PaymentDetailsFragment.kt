package com.example.mymealmonkey.view.fragment.paymentDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.AddCardDetailsData
import com.example.mymealmonkey.data.CardDetailsData
import com.example.mymealmonkey.databinding.FragmentPaymentDetailsBinding
import com.example.mymealmonkey.view.dialog.AddCardBottomSheetFragment
import com.example.mymealmonkey.utils.AddCardBottomSheet
import com.example.mymealmonkey.utils.BaseItemClickListener
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class PaymentDetailsFragment : Fragment(), AddCardBottomSheet {

    // Binding Components
    lateinit var binding: FragmentPaymentDetailsBinding

    // ViewModel Initialization
    private val viewModel: PaymentDetailsFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Data Binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_payment_details, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bottom Sheet Dialog
        val addCardBottomSheetFragment = AddCardBottomSheetFragment(this)
        val userList = viewModel.paymentDetails.value ?: ArrayList()

        if (viewModel.paymentDetailsFragmentAdapter == null) {
            viewModel.paymentDetailsFragmentAdapter =
                PaymentDetailsFragmentAdapter(
                    paymentDetailUserList = viewModel.paymentDetails.value ?: userList,
                )
        }

        binding.paymentdetailsRecyclerView.adapter =
            viewModel.paymentDetailsFragmentAdapter?.apply {
                setOnItemClickListener(object : BaseItemClickListener {
                    override fun itemClick(position: Int) {
                        userList.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeRemoved(0, userList.size)
                        viewModel.userCardDetailsList = userList

//                        runBlocking {
//                            val list = viewModel.cardDetailsDatabase.cardDetailsDao().getCardNumber()
//                            viewModel.cardDetailsDatabase.cardDetailsDao().deleteCard(list?.get(position) ?: "")
//                        }
                    }
                })
            }

        binding.paymentdetailsRecyclerView.hasFixedSize()

        binding.addCardButtonPaymentDetails.setOnClickListener {
            addCardBottomSheetFragment.isCancelable = false
            addCardBottomSheetFragment.show(parentFragmentManager, getString(R.string.addcardbottomsheetfragment))
        }

        // Set ClickListeners
        clickListeners()
    }

    // Set ClickListeners
    private fun clickListeners() {

        binding.paymentDetailsBackArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    //Function to refresh the Recycler view on change in data
    override fun refreshRecyclerView(arguments: Bundle) {

        val jsonAddedCardDetails = arguments.getString(getString(R.string.addcarddetailsdata))
        if (jsonAddedCardDetails != null) {
            val addedCardDetails = Gson().fromJson(
                jsonAddedCardDetails,
                AddCardDetailsData::class.java
            )

            val last4Char =
                addedCardDetails.cardNumber.toString()
                    .substring((addedCardDetails.cardNumber.toString().length) - 4)

            viewModel.addPaymentDetailsUserList(
                resources.getString(R.string.card_star) + " $last4Char",
                R.drawable.baseline_credit_card_svg
            )

            binding.paymentdetailsRecyclerView.adapter?.notifyItemInserted(
                viewModel.paymentDetails.value?.size ?: 0
            )

            val cardDetails = CardDetailsData(
                null,
                addedCardDetails.cardNumber.toString(),
                addedCardDetails.cardMonth.toString(),
                addedCardDetails.cardYear.toString(),
                addedCardDetails.securityCode.toString(),
                addedCardDetails.firstName.toString(),
                addedCardDetails.lastName.toString(),
            )

            runBlocking {
                viewModel.setCardDetails(cardDetails)
                viewModel.getCardNumber() ?: ArrayList()
            }
        }
    }
}
