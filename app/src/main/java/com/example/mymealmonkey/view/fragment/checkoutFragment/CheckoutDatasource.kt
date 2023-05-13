package com.example.mymealmonkey.view.fragment.checkoutFragment

import com.example.mymealmonkey.R

class CheckoutDatasource {
    fun loadCheckout():List<CheckoutData>{
        return listOf (
            CheckoutData(R.color.grey,R.string.cash_on_delivery,R.id.checkoutRadioButtonRV),
            CheckoutData(R.drawable.baseline_credit_card_svg,R.string.__2187,R.id.checkoutRadioButtonRV),
            CheckoutData(R.drawable.baseline_credit_card_svg,R.string.john_doe_mail,R.id.checkoutRadioButtonRV)
        )
    }
}