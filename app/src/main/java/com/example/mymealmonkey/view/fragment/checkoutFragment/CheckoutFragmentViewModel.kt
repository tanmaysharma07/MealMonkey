package com.example.mymealmonkey.view.fragment.checkoutFragment

import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.data.CardDetailsData
import com.example.mymealmonkey.database.db.CardDetailsDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckoutFragmentViewModel @Inject constructor(private val cardDetailsDatabase: CardDetailsDatabase) :
    ViewModel() {

    //Function to insert new card details in Database
    suspend fun setCardDetails(cardDetailsData: CardDetailsData) {
        return cardDetailsDatabase.cardDetailsDao().insert(cardDetailsData)
    }
}