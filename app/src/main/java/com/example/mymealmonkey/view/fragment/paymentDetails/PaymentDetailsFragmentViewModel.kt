package com.example.mymealmonkey.view.fragment.paymentDetails

import android.database.Observable
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class PaymentDetailsFragmentViewModel @Inject constructor(
): ViewModel() {
    val cardNumber = ObservableField("")
    val cardMonth = ObservableField("")
    val cardYear = ObservableField("")
    val cardSecurityCode = ObservableField("")
    val cardFirstName = ObservableField("")
    val cardLastName = ObservableField("")

    private val calendar: Calendar = Calendar.getInstance()

    fun isCardNumber():Boolean{
        return(cardNumber.get().toString().length != 16)
    }

    fun isCardMonth():Boolean{
        return((cardMonth.get()?.toInt()?:0) > 12 || (cardMonth.get()?.toInt()?:0)<1)
    }

    fun isCardYear():Boolean{
        return ((cardMonth.get()?.toInt()?:0)<calendar.get(Calendar.YEAR))
    }

    fun isEmpty():Boolean{
        return (cardSecurityCode.get().toString().isEmpty() || cardFirstName.get().toString().isEmpty() || cardLastName.get().toString().isEmpty())
    }
}