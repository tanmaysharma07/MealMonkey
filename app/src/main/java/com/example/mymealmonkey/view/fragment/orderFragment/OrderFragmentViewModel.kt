package com.example.mymealmonkey.view.fragment.orderFragment

import android.database.Observable
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class OrderFragmentViewModel():ViewModel() {

    val portionInput = ObservableField("1")
    private var _total = MutableLiveData<String>()
    val total:LiveData<String>
    get() = _total


     init {
         _total.value = (750*(portionInput.get()?.toIntOrNull() ?: 0)).toString()
         Log.d("HOOLA",portionInput.get().toString())
         Log.d("HOOLA",total.value.toString())
     }

    fun increasePortion(){
        if ((portionInput.get()?.toInt() ?: 0) >= 0){
            portionInput.set(portionInput.get()?.toIntOrNull()?.plus(1).toString())
        }
        _total.value = (750*(portionInput.get()?.toIntOrNull() ?: 0)).toString()
        Log.d("HOOLAI",portionInput.get().toString())
        Log.d("HOOLA",total.value.toString())
    }

    fun decreasePortion(){
        if ((portionInput.get()?.toInt() ?: 0) > 0){
            portionInput.set(portionInput.get()?.toIntOrNull()?.minus(1).toString())
        }
        _total.value = (750*(portionInput.get()?.toIntOrNull() ?: 0)).toString()
        Log.d("HOOLAD",portionInput.get().toString())
        Log.d("HOOLA",total.value.toString())
    }
}