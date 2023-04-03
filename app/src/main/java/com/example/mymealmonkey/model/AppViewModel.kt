package com.example.mymealmonkey.model

import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {

    fun isFieldEmpty(input:String):Boolean{
        return input.trim().isEmpty()
    }
}