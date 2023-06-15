package com.example.mymealmonkey.view.fragment.checkoutFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.AddCardDetailsData
import com.example.mymealmonkey.data.CardDetailsData
import com.example.mymealmonkey.databinding.FragmentCheckoutBinding
import com.example.mymealmonkey.utils.AddCardBottomSheet
import com.example.mymealmonkey.utils.BaseItemClickListener
import com.example.mymealmonkey.view.dialog.AddCardBottomSheetFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CheckoutFragment : Fragment(), AddCardBottomSheet {

    // ViewModel Initialization
    val viewModel: CheckoutFragmentViewModel by viewModels()

    //Binding Component
    lateinit var binding: FragmentCheckoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Object of Bottom Sheet
        val addCardBottomSheetFragment = AddCardBottomSheetFragment(this)

        // Array List to store Data
        val checkoutArray = ArrayList<CheckoutData>()

        checkoutArray.addAll(
            arrayOf(
                CheckoutData(R.color.grey, R.string.cash_on_delivery, R.id.checkoutRadioButtonRV),
                CheckoutData(
                    R.drawable.baseline_credit_card_svg,
                    R.string.__2187,
                    R.id.checkoutRadioButtonRV
                ),
                CheckoutData(
                    R.drawable.baseline_credit_card_svg,
                    R.string.john_doe_mail,
                    R.id.checkoutRadioButtonRV
                )
            )
        )

        // RecyclerView Initialized
        val checkoutAdapter = CheckoutAdapter(checkoutArray)
        binding.checkoutRecyclerView.adapter = checkoutAdapter.apply {
            setOnItemClickListener(object : BaseItemClickListener {
                override fun itemClick(position: Int) {

                }
            })
        }
        binding.checkoutRecyclerView.hasFixedSize()

        //Inflate Bottom Sheet on Click of Button
        binding.addCardCheckout.setOnClickListener {
            addCardBottomSheetFragment.isCancelable = false
            addCardBottomSheetFragment.show(
                parentFragmentManager,
                getString(R.string.addcardbottomsheetfragment)
            )
        }

        // Track Order Bottom Sheet
        binding.sendOrderButtonCheckout.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.track_order_bottom_sheet, null)
            val closeButton: ImageView = view.findViewById(R.id.trackOrderBottomSheetClose)
            val trackMyOrder: Button = view.findViewById(R.id.trackMyOrderButton)
            closeButton.setOnClickListener {
                dialog.dismiss()
            }
            trackMyOrder.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }
    }

    override fun refreshRecyclerView(arguments: Bundle) {

        val jsonAddedCardDetails = arguments.getString(getString(R.string.addcarddetailsdata))
        if (jsonAddedCardDetails != null) {
            val addedCardDetails = Gson().fromJson(
                jsonAddedCardDetails,
                AddCardDetailsData::class.java
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

            lifecycleScope.launch() {
                viewModel.setCardDetails(cardDetails)
            }
        }
    }
}