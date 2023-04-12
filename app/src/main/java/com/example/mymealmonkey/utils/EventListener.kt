package com.example.mymealmonkey.utils

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventListener @Inject constructor() {
    var showBottomNavigation = MutableLiveData(false)
}