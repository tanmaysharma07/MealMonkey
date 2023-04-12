package com.example.mymealmonkey.view.fragment.menuFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private val menuFragmentViewModel: MenuFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuFragmentViewModel.eventListener.checkable.postValue("Menu")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuFragmentViewModel.eventListener.showBottomNavigationLD.postValue(true)
        menuFragmentViewModel.eventListener.fabColor.postValue("Grey")
    }

    override fun onResume() {
        super.onResume()
        menuFragmentViewModel.eventListener.checkable.postValue("Menu")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        menuFragmentViewModel.eventListener.checkable.postValue("")
    }
}