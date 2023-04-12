package com.example.mymealmonkey.view.fragment.latestOffers

import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LatestOffersViewModel @Inject constructor(val eventListener: EventListener): ViewModel() {

}