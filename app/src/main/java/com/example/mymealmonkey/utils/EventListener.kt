package com.example.mymealmonkey.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventListener @Inject constructor() {

    private val _showBottomNavigationLD = MutableLiveData(false)
    val showBottomNavigationLD:LiveData<Boolean>  = _showBottomNavigationLD


    fun showBottomNavigation(){
        _showBottomNavigationLD.postValue(true)
    }
    fun hideBottomNavigation(){
        _showBottomNavigationLD.postValue(false)
    }

    var checkable = MutableLiveData("")
    var fabColor = MutableLiveData("")

//    var menuCheckable = MutableLiveData(false)
//    var offersCheckable = MutableLiveData(false)
//    var profileCheckable = MutableLiveData(false)
//    var moreCheckable = MutableLiveData(false)

}