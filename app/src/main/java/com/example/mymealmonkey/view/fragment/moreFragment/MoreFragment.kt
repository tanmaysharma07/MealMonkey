package com.example.mymealmonkey.view.fragment.moreFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFragment : Fragment() {

    private val moreFragmentViewModel: MoreFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moreFragmentViewModel.eventListener.checkable.postValue("More")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moreFragmentViewModel.eventListener.showBottomNavigationLD.postValue(true)
        moreFragmentViewModel.eventListener.fabColor.postValue("Grey")
    }

    override fun onResume() {
        super.onResume()
        moreFragmentViewModel.eventListener.checkable.postValue("More")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        moreFragmentViewModel.eventListener.checkable.postValue("")
    }
}