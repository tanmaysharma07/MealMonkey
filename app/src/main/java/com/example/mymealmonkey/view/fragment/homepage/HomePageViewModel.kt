package com.example.mymealmonkey.view.fragment.homepage

import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.R
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(val eventListener: EventListener): ViewModel() {
}
