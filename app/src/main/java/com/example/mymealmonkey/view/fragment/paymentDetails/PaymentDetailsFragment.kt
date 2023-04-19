package com.example.mymealmonkey.view.fragment.paymentDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentMoreBinding
import com.example.mymealmonkey.databinding.FragmentPaymentDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class PaymentDetailsFragment : Fragment() {

    lateinit var binding: FragmentPaymentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addButton = view.findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.payment_detail_bottom_sheet, null)
            val closeButton = view.findViewById<ImageView>(R.id.notification_bottom_sheet_close)
            closeButton.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }
    }
}
