package com.example.mymealmonkey.view.fragment.imageSlider

import androidx.lifecycle.ViewModel
import com.example.mymealmonkey.R
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageSliderPageViewModel @Inject constructor(val eventListener: EventListener): ViewModel() {
}

data class ImageSliderData(
    val head:String?,
    val body:String?
)

