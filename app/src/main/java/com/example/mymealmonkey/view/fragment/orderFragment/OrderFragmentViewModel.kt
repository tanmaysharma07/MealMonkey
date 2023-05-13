package com.example.mymealmonkey.view.fragment.orderFragment

import android.database.Observable
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class OrderFragmentViewModel() : ViewModel() {

    // Observable Field catch Live data
    val portionInput = ObservableField("1")

    //Live Data
    private var _total = MutableLiveData<String>()
    val total: LiveData<String>
        get() = _total

    init {
        total()
    }

    // Function to calculate Total
    fun total() {
        _total.value = (750 * (portionInput.get()?.toIntOrNull() ?: 0)).toString()
    }

    // Function for when user increase portion with Button
    fun increasePortion() {
        if ((portionInput.get()?.toIntOrNull() ?: 0) >= 0) {
            portionInput.set(portionInput.get()?.toIntOrNull()?.plus(1).toString())
        }
        _total.value = (750 * (portionInput.get()?.toIntOrNull() ?: 0)).toString()
    }

    // Function for when user decrease portion with Button
    fun decreasePortion() {
        if ((portionInput.get()?.toIntOrNull() ?: 0) > 0) {
            portionInput.set(portionInput.get()?.toIntOrNull()?.minus(1).toString())
        }
        _total.value = (750 * (portionInput.get()?.toIntOrNull() ?: 0)).toString()
    }
}