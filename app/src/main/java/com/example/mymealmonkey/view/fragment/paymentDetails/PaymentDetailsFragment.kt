package com.example.mymealmonkey.view.fragment.paymentDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentMoreBinding
import com.example.mymealmonkey.databinding.FragmentPaymentDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentDetailsFragment : Fragment() {

    // Binding Components
    lateinit var binding: FragmentPaymentDetailsBinding

    private val viewModel:PaymentDetailsFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View Binding
        binding = FragmentPaymentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list:MutableList<PaymentDetailsFragmentData> = PaymentDetailsFragmentDatasource().loadPaymentDetails().toMutableList()

        //Inflate Bottom Sheet on Click of Button
        binding.addCardButtonPaymentDetails.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.payment_detail_bottom_sheet, null)
            val closeButton = view.findViewById<ImageView>(R.id.notification_bottom_sheet_close)
            val cardNumber:TextInputEditText = view.findViewById(R.id.cardNumberEditText)

            val last4Number = cardNumber.toString().substring(cardNumber.toString().length - 4)
            closeButton.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            list.add(PaymentDetailsFragmentData(resources.getString(R.string.card_star)+" $cardNumber",R.drawable.baseline_credit_card_svg))
        }

        val datasetPaymentDetails = PaymentDetailsFragmentDatasource().loadPaymentDetails()
        binding.paymentdetailsRecyclerView.adapter = PaymentDetailsFragmentAdapter(this,datasetPaymentDetails)
        binding.paymentdetailsRecyclerView.hasFixedSize()
    }
}
