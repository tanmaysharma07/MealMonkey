package com.example.mymealmonkey.view.dialog

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.utils.isNotValidCardMonth
import com.example.mymealmonkey.utils.isNotValidCardNumber
import com.example.mymealmonkey.utils.isNotValidCardYear
import com.example.mymealmonkey.utils.isNotValidInput

class AddCardBottomSheetVM : ViewModel() {

    // UI Fields
    val cardNumber = ObservableField("")
    val cardMonth = ObservableField("")
    val cardYear = ObservableField("")
    val cardSecurityCode = ObservableField("")
    val cardFirstName = ObservableField("")
    val cardLastName = ObservableField("")

    //Check if card number is Valid
    fun isCardNumberValid(): Boolean {
        return (cardNumber.get()?.isNotValidCardNumber() ?: true)
    }

    //Check if card month is Valid
    fun isCardMonthValid(): Boolean {
        return (cardMonth.get()?.isNotValidCardMonth() ?: true)
    }

    //Check if Card year is Valid
    fun isCardYearValid(): Boolean {
        return (cardYear.get()?.isNotValidCardYear() ?: true)
    }

    //Check if Security Code is Valid
    fun isSecurityCodeValid(): Boolean {
        return (cardSecurityCode.get()?.isNotValidInput() ?: true)
    }

    //Check if First Nane is Valid
    fun isFirstNameValid(): Boolean {
        return (cardFirstName.get()?.isNotValidInput() ?: true)
    }

    //Check if Last Name is Valid
    fun isLastNameValid(): Boolean {
        return (cardLastName.get()?.isNotValidInput() ?: true)
    }
}