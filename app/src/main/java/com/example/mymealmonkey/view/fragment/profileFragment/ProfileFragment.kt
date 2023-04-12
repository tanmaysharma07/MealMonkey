package com.example.mymealmonkey.view.fragment.profileFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val profileFragmentViewModel: ProfileFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileFragmentViewModel.eventListener.showBottomNavigationLD.postValue(true)
        profileFragmentViewModel.eventListener.fabColor.postValue("Grey")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        profileFragmentViewModel.eventListener.checkable.postValue("Profile")
    }
    override fun onResume() {
        super.onResume()
        profileFragmentViewModel.eventListener.checkable.postValue("Profile")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        profileFragmentViewModel.eventListener.checkable.postValue("")
    }
}