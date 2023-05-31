package com.example.mymealmonkey.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventListener @Inject constructor() {
    enum class BottomNavigation {
        HOME, MENU, PROFILE, MORE, OFFERS, OTHER
    }

    // Handle Bottom Navigation Bar Visibility
    private val _showBottomNavigationLD = MutableLiveData(false)
    val showBottomNavigationLD: LiveData<Boolean> = _showBottomNavigationLD

    private val _selectBottomNavigationItem = MutableLiveData<BottomNavigation>()
    val selectBottomNavigationItem: LiveData<BottomNavigation> = _selectBottomNavigationItem

    /**
     * Select Bottom Navigation Item
     *
     * @param item [BottomNavigation]
     * */
    fun selectBottomNavigationItem(item: BottomNavigation) {
        _selectBottomNavigationItem.postValue(item)
    }

//    fun showBottomNavigation() {
//        _showBottomNavigationLD.postValue(true)
//    }
//
//    fun hideBottomNavigation() {
//        _showBottomNavigationLD.postValue(false)
//    }
//
//    var checkable = MutableLiveData(true)
//    var fabColor = MutableLiveData("")

    lateinit var resetEmail: String
}