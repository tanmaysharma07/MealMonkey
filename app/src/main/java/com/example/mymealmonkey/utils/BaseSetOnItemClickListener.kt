package com.example.mymealmonkey.utils

interface BaseSetOnItemClickListener {

    var adapterClickListener: BaseItemClickListener
    fun setOnItemClickListener(clickListener: BaseItemClickListener)
}