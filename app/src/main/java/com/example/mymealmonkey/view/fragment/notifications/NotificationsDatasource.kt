package com.example.mymealmonkey.view.fragment.notifications

import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.notifications.NotificationsData

class NotificationsDatasource {
    fun loadNotifications():List<NotificationsData> {
        return listOf(
            NotificationsData(R.string.your_orders_has_been_picked_up,R.string.now),
            NotificationsData(R.string.your_orders_has_been_picked_up,R.string.now),
            NotificationsData(R.string.your_orders_has_been_picked_up,R.string.now),
            NotificationsData(R.string.your_orders_has_been_picked_up,R.string.now),
            NotificationsData(R.string.your_orders_has_been_picked_up,R.string.now),
            NotificationsData(R.string.your_orders_has_been_picked_up,R.string.now),
            NotificationsData(R.string.your_orders_has_been_picked_up,R.string.now),
            NotificationsData(R.string.your_orders_has_been_picked_up,R.string.now)
        )
    }

}