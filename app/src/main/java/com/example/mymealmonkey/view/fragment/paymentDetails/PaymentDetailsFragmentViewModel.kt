package com.example.mymealmonkey.view.fragment.paymentDetails

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.CardDetailsData
import com.example.mymealmonkey.database.db.CardDetailsDatabase
import com.example.mymealmonkey.utils.AppPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentDetailsFragmentViewModel @Inject constructor(
    val appPreferences: AppPreferences,
    val cardDetailsDatabase: CardDetailsDatabase
) : ViewModel() {

    //UI Fields
    val cardNumber = ObservableField("")
    val cardMonth = ObservableField("")
    val cardYear = ObservableField("")
    val cardSecurityCode = ObservableField("")
    val cardFirstName = ObservableField("")
    val cardLastName = ObservableField("")

    // Live Data for Card Details
    private val _paymentDetails = MutableLiveData<ArrayList<PaymentDetailsFragmentData>>()
    val paymentDetails: LiveData<ArrayList<PaymentDetailsFragmentData>> = _paymentDetails

    // List to store data of user card details
    var userCardDetailsList = ArrayList<PaymentDetailsFragmentData>()

    var paymentDetailsFragmentAdapter: PaymentDetailsFragmentAdapter? = null

    // Add one card to list at start
    init {
        viewModelScope.launch() {
            var list = cardDetailsDatabase.cardDetailsDao().getCardNumber()
            Log.d("HOHO", list.toString())
            if (userCardDetailsList.size <= 0) {
                for (i in 0 until (list?.size ?: 0)) {
                    val displayCardNumber = list?.get(i)?.substring(12, 16)
                    userCardDetailsList.add(
                        PaymentDetailsFragmentData(
                            "**** **** **** $displayCardNumber" ?: "Cash on Delivery",
                            R.drawable.baseline_credit_card_svg
                        )
                    )
                }
            }
            paymentDetailsFragmentAdapter?.notifyItemInserted(list?.size ?: 0)
            saveData(userCardDetailsList)
        }
    }

    //Function to insert new card details in Database
    suspend fun setCardDetails(cardDetailsData: CardDetailsData) {
        return cardDetailsDatabase.cardDetailsDao().insert(cardDetailsData)
    }

    //Function to get the card details in Database
    suspend fun getCardNumber(): List<String>? {
        return cardDetailsDatabase.cardDetailsDao().getCardNumber()
    }

    //Function to insert new card details in List
    fun addPaymentDetailsUserList(string: String, drawable: Int) {
        userCardDetailsList.add(PaymentDetailsFragmentData(string, drawable))
        saveData(userCardDetailsList)
    }

    //Function to save new card details in list at start
    private fun saveData(data: ArrayList<PaymentDetailsFragmentData>) {
        _paymentDetails.value = data
    }
}