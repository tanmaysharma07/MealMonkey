package com.example.mymealmonkey.fragment

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymealmonkey.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePageFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BottomNavigationView.OnNavigationItemSelectedListener{ item ->
            when(item.itemId) {
                R.id.home_page -> {

                    true
                }
                R.id.menu_page -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }
    }
}