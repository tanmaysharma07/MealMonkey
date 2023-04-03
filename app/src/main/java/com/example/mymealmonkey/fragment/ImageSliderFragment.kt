package com.example.mymealmonkey.fragment

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.mymealmonkey.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout


class ImageSliderFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.mymealmonkey.R.layout.fragment_image_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var viewPagerAdapter: ViewPagerAdapter
        lateinit var imageList: List<Int>
        var num: Int = 0

        val viewPager: ViewPager = view.findViewById(com.example.mymealmonkey.R.id.viewpager)
        val indicator: TabLayout = view.findViewById(com.example.mymealmonkey.R.id.indicator)
        val fastDelivery: TextView = view.findViewById(com.example.mymealmonkey.R.id.fast_deliveryt)
        val fastDeliveryText: TextView = view.findViewById(com.example.mymealmonkey.R.id.fast_delivery_text)

        // on below line we are initializing
        // our image list and adding data to it.
        imageList = ArrayList<Int>()
        imageList = imageList + com.example.mymealmonkey.R.drawable.find_food_you_love_vector
        imageList =imageList + com.example.mymealmonkey.R.drawable.delivery_vector
        imageList =  imageList + com.example.mymealmonkey.R.drawable.live_tracking_vector

        viewPagerAdapter = ViewPagerAdapter(requireContext(), imageList)

        viewPager.adapter = viewPagerAdapter
        indicator.setupWithViewPager(viewPager, true)

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        fastDelivery.text = getString(com.example.mymealmonkey.R.string.find_food_you_love)
                        fastDeliveryText.text = getString(com.example.mymealmonkey.R.string.discover_the_best_foods_from_over_1_000_restaurants_and_fast_delivery_to_your_doorstep)
                    }
                    1 -> {
                        fastDelivery.text = getString(com.example.mymealmonkey.R.string.fast_delivery)
                        fastDeliveryText.text = getString(com.example.mymealmonkey.R.string.fast_food_delivery_to_your_home_office_wherever_you_are)
                    }
                    2 -> {
                        fastDelivery.text = getString(com.example.mymealmonkey.R.string.live_tracking)
                        fastDeliveryText.text = getString(com.example.mymealmonkey.R.string.real_time_tracking_of_your_food_on_the_app_once_you_placed_the_order)
                    }
                    else -> {}
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })
        val liveTrackingButton: Button = view.findViewById(com.example.mymealmonkey.R.id.viewpager_button)
        liveTrackingButton.setOnClickListener {
            it.findNavController().navigate(com.example.mymealmonkey.R.id.action_imageSliderFragment_to_homePageFragment)
        }
    }
}
