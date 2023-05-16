package com.example.mymealmonkey.view.fragment.paymentDetails

import com.example.mymealmonkey.R

class PaymentDetailsFragmentDatasource {

    private val paymentDetailsList = ArrayList<PaymentDetailsFragmentData>()

    init {
        paymentDetailsList.add(PaymentDetailsFragmentData("**** **** **** 2187", R.drawable.baseline_credit_card_svg))
    }

    fun addList(string: String,drawable: Int){
        paymentDetailsList.add(PaymentDetailsFragmentData(string, drawable))
    }

    fun loadPaymentDetails(): List<PaymentDetailsFragmentData> {
        return paymentDetailsList
    }
}