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
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar

class CheckoutFragment : Fragment() {

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

        val calendar: Calendar = Calendar.getInstance()

        val checkoutDataset = CheckoutDatasource().loadCheckout()
        binding.checkoutRecyclerView.adapter = CheckoutAdapter(this, checkoutDataset)
        binding.checkoutRecyclerView.hasFixedSize()

        //Inflate Bottom Sheet on Click of Button
        binding.addCardCheckout.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.payment_detail_bottom_sheet, null)
            val closeButton = view.findViewById<ImageView>(R.id.notification_bottom_sheet_close)
            val addButton = view.findViewById<Button>(R.id.add_card)
            val cardNumber = view.findViewById<TextInputLayout>(R.id.cardNumber)
            val cardMonth = view.findViewById<TextInputLayout>(R.id.cardMonth)
            val cardYear = view.findViewById<TextInputLayout>(R.id.cardYear)
            val cardSecurityCode = view.findViewById<TextInputLayout>(R.id.cardSecurityCode)
            val cardFirstName = view.findViewById<TextInputLayout>(R.id.cardFirstName)
            val cardLastName = view.findViewById<TextInputLayout>(R.id.cardLastName)

            closeButton.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            addButton.setOnClickListener {

                if (cardNumber.editText?.text.toString().length != 16) {
                    cardNumber.helperText = "Invalid Card Number"
                    return@setOnClickListener
                }
                cardNumber.helperText = null

                if (((cardMonth.editText?.text?.toString()?.toIntOrNull()
                        ?: 0) > 12) || (cardMonth.editText?.text?.toString()?.toIntOrNull()
                        ?: 0) < 1
                ) {
                    cardMonth.helperText = "Invalid Month"
                    return@setOnClickListener
                }

                cardMonth.helperText = null

                if ((cardYear.editText?.text.toString().toIntOrNull()
                        ?: 0) < calendar.get(Calendar.YEAR)
                ) {
                    cardYear.helperText = "Invalid Year"
                    return@setOnClickListener
                }

                cardYear.helperText = null

                if (cardSecurityCode.editText?.text.toString()
                        .isEmpty() || cardFirstName.editText?.text.toString()
                        .isEmpty() || cardLastName.editText?.text.toString().isEmpty()
                ) {
                    cardSecurityCode.helperText = "Invalid Code"
                    cardFirstName.helperText = "Enter First Name"
                    cardLastName.helperText = "Enter Last Name"
                    return@setOnClickListener
                }
                cardSecurityCode.helperText = null
                cardFirstName.helperText = null
                cardLastName.helperText = null

                val last4Char =
                    cardNumber.editText?.text.toString()
                        .substring((cardNumber.editText?.text?.length ?: 0) - 4)

                dialog.dismiss()
            }
        }

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
}