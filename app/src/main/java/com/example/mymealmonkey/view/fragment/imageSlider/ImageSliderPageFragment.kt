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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageSliderPageFragment : Fragment() {

    private lateinit var binding: FragmentImageSliderBinding
    private val viewModel: ImageSliderPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageSliderBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Set Click Listeners
         */
        clickListeners()

        //Putting Images in a ArrayList
        var imageList: List<Int>
        imageList = ArrayList()
        imageList = imageList + R.drawable.find_food_you_love_vector
        imageList = imageList + R.drawable.delivery_vector
        imageList = imageList + R.drawable.live_tracking_vector

        // Initializing Adapter and Indiicator
        val viewPagerAdapter = ViewPagerAdapter(requireContext(), imageList)
        binding.viewpager.adapter = viewPagerAdapter
        binding.indicator.setupWithViewPager(binding.viewpager, true)

        // Text data Shown below the Image as it changes
        val imageSliderData = listOf(
            ImageSliderData(
                "Find Food You Love",
                "Discover the best foods from over 1,000 restaurants and fast delivery to your doorstep"
            ),
            ImageSliderData(
                "Fast Delivery",
                "Fast food delivery to your home, office wherever you are"
            ),
            ImageSliderData(
                "Live Tracking",
                "Real time tracking of your food on the app once you placed the order"
            )
        )

        // Allow to change Text as Page changes
        binding.viewpager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.headText.text = imageSliderData[position].head
                        binding.bodyText.text = imageSliderData[position].body
                    }
                    1 -> {
                        binding.headText.text = imageSliderData[position].head
                        binding.bodyText.text = imageSliderData[position].body
                    }
                    2 -> {
                        binding.headText.text = imageSliderData[position].head
                        binding.bodyText.text = imageSliderData[position].body
                    }
                    else -> {}
                }
            }
            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })
    }

    /**
     * Set Click Listeners
     */
    private fun clickListeners() {
        binding.imageSliderButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_imageSliderFragment_to_homePageFragment)
        }
    }
}
