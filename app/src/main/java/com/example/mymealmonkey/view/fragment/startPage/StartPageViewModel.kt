package com.example.mymealmonkey.view.fragment.startPage

import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartPageViewModel @Inject constructor(val eventListener: EventListener):ViewModel() {
}