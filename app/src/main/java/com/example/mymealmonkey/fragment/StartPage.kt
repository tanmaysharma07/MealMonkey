package com.example.mymealmonkey.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.mymealmonkey.R

class StartPage : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var login_button:Button = view.findViewById(R.id.login_button)
        var create_account_button:Button = view.findViewById(R.id.create_account_button)
        login_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_startPage_to_loginPage)
        }
        create_account_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_startPage_to_signUpPage)
        }
    }
}