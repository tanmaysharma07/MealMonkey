package com.example.mymealmonkey.view.fragment.paymentDetails

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.CardDetailsData
import com.example.mymealmonkey.utils.AppPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class PaymentDetailsFragmentViewModel @Inject constructor(
    val eventListener: com.example.mymealmonkey.utils.EventListener,
    val appPreferences: AppPreferences
) : ViewModel() {
    val cardNumber = ObservableField("")
    val cardMonth = ObservableField("")
    val cardYear = ObservableField("")
    val cardSecurityCode = ObservableField("")
    val cardFirstName = ObservableField("")
    val cardLastName = ObservableField("")

    private val _paymentDetails = MutableLiveData<ArrayList<PaymentDetailsFragmentData>>()
    val paymentDetails: LiveData<ArrayList<PaymentDetailsFragmentData>> = _paymentDetails

    var paymentDetailsFragmentAdapter: PaymentDetailsFragmentAdapter? = null

    init {
        if (eventListener.list.size <= 0) {
            eventListener.list.add(
                PaymentDetailsFragmentData(
                    "**** **** **** 2187", R.drawable.baseline_credit_card_svg
                )
            )
        }
        saveData(eventListener.list)
    }

    suspend fun setCardDetails(cardDetailsData: CardDetailsData) {
        return appPreferences.setCardDetailsData(cardDetailsData)
    }

    suspend fun getCardNumber(): List<String>? {
        return appPreferences.getCardNumber()
    }

    fun addPaymentDetailsUserList(string: String, drawable: Int) {
        eventListener.list.add(PaymentDetailsFragmentData(string, drawable))
        saveData(eventListener.list)
    }

    private fun saveData(data: ArrayList<PaymentDetailsFragmentData>) {
        _paymentDetails.value = data
    }
}