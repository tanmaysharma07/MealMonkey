package com.example.mymealmonkey.view.fragment.checkoutFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentCheckoutBinding
import com.example.mymealmonkey.view.dialog.AddCardBottomSheetFragment
import com.example.mymealmonkey.utils.AddCardBottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialog

class CheckoutFragment : Fragment(), AddCardBottomSheet {

    val viewModel: CheckoutFragmentViewModel by viewModels()
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

        val addCardBottomSheetFragment = AddCardBottomSheetFragment(this)

        val checkoutArray = ArrayList<CheckoutData>()

            checkoutArray.addAll(
            arrayOf(
                    CheckoutData(R.color.grey,R.string.cash_on_delivery,R.id.checkoutRadioButtonRV),
                    CheckoutData(R.drawable.baseline_credit_card_svg,R.string.__2187,R.id.checkoutRadioButtonRV),
                    CheckoutData(R.drawable.baseline_credit_card_svg,R.string.john_doe_mail,R.id.checkoutRadioButtonRV)
            )
        )

        // RecyclerView Initialized
        binding.checkoutRecyclerView.adapter = CheckoutAdapter(checkoutArray)
        binding.checkoutRecyclerView.hasFixedSize()

        //Inflate Bottom Sheet on Click of Button
        binding.addCardCheckout.setOnClickListener {
            addCardBottomSheetFragment.isCancelable = false
            addCardBottomSheetFragment.show(parentFragmentManager, getString(R.string.addcardbottomsheetfragment))

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
    }
}