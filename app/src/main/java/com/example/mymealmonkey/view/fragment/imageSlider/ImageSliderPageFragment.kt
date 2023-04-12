package com.example.mymealmonkey.view.fragment.imageSlider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentImageSliderBinding
import com.example.mymealmonkey.view.fragment.homepage.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageSliderPageFragment : Fragment() {

   private lateinit var binding:FragmentImageSliderBinding
   private val imageSliderPageViewModel:ImageSliderPageViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageSliderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderPageViewModel.eventListener.showBottomNavigation.postValue(false)

        lateinit var imageList: List<Int>
        val viewPager = binding.viewpager
        val indicator = binding.indicator
        val fastDelivery = binding.fastDelivery
        val fastDeliveryText= binding.fastDeliveryText

        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.find_food_you_love_vector
        imageList = imageList + R.drawable.delivery_vector
        imageList = imageList + R.drawable.live_tracking_vector

        val viewPagerAdapter = ViewPagerAdapter(requireContext(), imageList)

        viewPager.adapter = viewPagerAdapter
        indicator.setupWithViewPager(viewPager, true)

        val imageSliderData  = listOf(
            ImageSliderData("Find Food You Love","Discover the best foods from over 1,000 restaurants and fast delivery to your doorstep"),
            ImageSliderData("Fast Delivery","Fast food delivery to your home, office wherever you are"),
            ImageSliderData("Live Tracking","Real time tracking of your food on the app once you placed the order")
        )

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        fastDelivery.text = imageSliderData[position].head
                        fastDeliveryText.text =imageSliderData[position].body
                    }
                    1 -> {
                        fastDelivery.text = imageSliderData[position].head
                        fastDeliveryText.text =imageSliderData[position].body
                    }
                    2 -> {
                        fastDelivery.text = imageSliderData[position].head
                        fastDeliveryText.text =imageSliderData[position].body
                    }
                    else -> {}
                }
            }
            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })
        binding.imageSliderButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_imageSliderFragment_to_homePageFragment)
        }
    }

}
