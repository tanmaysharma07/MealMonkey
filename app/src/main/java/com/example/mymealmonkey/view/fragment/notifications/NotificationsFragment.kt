package com.example.mymealmonkey.view.fragment.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
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

        // Array for Notification Details
        val notificationArray = ArrayList<NotificationsData>()
        notificationArray.addAll(
            arrayOf(
                NotificationsData(R.string.your_orders_has_been_picked_up, R.string.now),
                NotificationsData(R.string.your_orders_has_been_picked_up, R.string.now),
                NotificationsData(R.string.your_orders_has_been_picked_up, R.string.now),
                NotificationsData(R.string.your_orders_has_been_picked_up, R.string.now),
                NotificationsData(R.string.your_orders_has_been_picked_up, R.string.now),
                NotificationsData(R.string.your_orders_has_been_picked_up, R.string.now),
                NotificationsData(R.string.your_orders_has_been_picked_up, R.string.now),
                NotificationsData(R.string.your_orders_has_been_picked_up, R.string.now)
            )
        )

        //Initialized RecyclerView
        binding.notificationsRecyclerView.adapter = NotificationsAdapter(notificationArray)
        binding.notificationsRecyclerView.hasFixedSize()

        clickListeners()
    }

    private fun clickListeners() {
        binding.notificationsBackArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}