package com.example.mymealmonkey.view.dialog

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import java.util.Calendar

class AddCardBottomSheetVM : ViewModel() {

    val cardNumber = ObservableField("")
    val cardMonth = ObservableField("")
    val cardYear = ObservableField("")
    val cardSecurityCode = ObservableField("")
    val cardFirstName = ObservableField("")
    val cardLastName = ObservableField("")

    private val calendar: Calendar = Calendar.getInstance()

    //Check if card number is Valid
    fun isCardNumberValid(): Boolean {
        return ((cardNumber.get()?.trim()?.isEmpty() ?: true))
    }

    //Check if card month is Valid
    fun isCardMonthValid(): Boolean {
        return (((cardMonth.get().toString().toIntOrNull()
            ?: 0) > 12) || (cardMonth.get().toString().toIntOrNull()
            ?: 0) < 1
                )
    }

    //Check if Card year is Valid
    fun isCardYearValid(): Boolean {
        return ((cardYear.get().toString().toIntOrNull()
            ?: 0) < calendar.get(Calendar.YEAR)
                )
    }

    //Check if Security Code is Valid
    fun isSecurityCodeValid():Boolean{
        return (cardSecurityCode.get().toString().trim().isEmpty())
    }

    //Check if First Nane is Valid
    fun isFirstNameValid():Boolean{
        return (cardFirstName.get().toString().trim().isEmpty())
    }

    //Check if Last Name is Valid
    fun isLastNameValid():Boolean{
        return (cardLastName.get().toString().trim().isEmpty())
    }
}