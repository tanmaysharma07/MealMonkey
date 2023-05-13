package com.example.mymealmonkey.view.fragment.paymentDetails

import com.example.mymealmonkey.R

class PaymentDetailsFragmentDatasource {
    fun loadPaymentDetails(): List<PaymentDetailsFragmentData> {
        return listOf<PaymentDetailsFragmentData>(
            PaymentDetailsFragmentData("**** **** **** 2187", R.drawable.baseline_credit_card_svg)
        )
    }
}