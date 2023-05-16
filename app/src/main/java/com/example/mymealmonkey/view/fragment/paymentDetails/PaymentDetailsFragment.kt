package com.example.mymealmonkey.view.fragment.paymentDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentPaymentDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class PaymentDetailsFragment : Fragment() {

    // Binding Components
    lateinit var binding: FragmentPaymentDetailsBinding

    private val viewModel: PaymentDetailsFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View Binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_payment_details, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var userList = ArrayList<PaymentDetailsFragmentData>()
        val calendar: Calendar = Calendar.getInstance()

        if (viewModel.adapter == null) {
            viewModel.adapter =
                PaymentDetailsFragmentAdapter(paymentDetailUserList = viewModel.paymentDetails.value ?: userList, Context =  this)
        }
        binding.paymentdetailsRecyclerView.adapter = viewModel.adapter
        binding.paymentdetailsRecyclerView.hasFixedSize()


        //Inflate Bottom Sheet on Click of Button
        binding.addCardButtonPaymentDetails.setOnClickListener {
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

                viewModel.addPaymentDetailsUserList(
                    resources.getString(R.string.card_star) + " $last4Char",
                    R.drawable.baseline_credit_card_svg
                )
                binding.paymentdetailsRecyclerView.adapter?.notifyItemInserted(
                    viewModel.paymentDetails.value?.size ?: 0
                )
                dialog.dismiss()
            }
        }

        binding.paymentDetailsBackArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
