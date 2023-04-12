package com.example.mymealmonkey.view.fragment.moreFragment

import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoreFragmentViewModel @Inject constructor(val eventListener: EventListener) : ViewModel() {
}