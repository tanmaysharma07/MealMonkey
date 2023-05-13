package com.example.mymealmonkey.view.fragment.moreFragment

import com.example.mymealmonkey.R

class MoreFragmentDatasource {
    fun loadMore(): List<MoreFragmentData> {
        return listOf<MoreFragmentData>(
            MoreFragmentData(
                R.drawable._02_income,
                R.string.payment_details,
                R.id.action_moreFragment_to_paymentDetailsFragment
            ),
            MoreFragmentData(
                R.drawable.shopping_bag,
                R.string.my_orders,
                R.id.action_moreFragment_to_myOrderFragment
            ),
            MoreFragmentData(
                R.drawable.group_8081,
                R.string.notification,
                R.id.action_moreFragment_to_notificationsFragment
            ),
            MoreFragmentData(
                R.drawable._04_inbox_mail,
                R.string.inbox,
                R.id.action_moreFragment_to_inboxFragment
            ),
            MoreFragmentData(
                R.drawable._05_info,
                R.string.about_us,
                R.id.action_moreFragment_to_aboutUsFragment
            )

        )

    }
}