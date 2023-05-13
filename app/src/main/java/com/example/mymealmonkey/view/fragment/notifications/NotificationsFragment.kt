package com.example.mymealmonkey.view.fragment.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymealmonkey.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    // Binding Component
    lateinit var binding: FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View Binding
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialized RecyclerView
        val notificationsDataset = NotificationsDatasource().loadNotifications()
        binding.notificationsRecyclerView.adapter = NotificationsAdapter(this, notificationsDataset)
        binding.notificationsRecyclerView.hasFixedSize()
    }
}