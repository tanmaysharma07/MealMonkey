package com.example.mymealmonkey.view.activity

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.ActivityMainBinding
import com.example.mymealmonkey.model.AppViewModel
import com.example.mymealmonkey.utils.EventListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: AppViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MyMealMonkey)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        supportActionBar?.hide()
        val bottomNavigationView = binding.bottomNavigationView
        val fabButton = binding.fabButton
//        val bottomAppBar = binding.bottomAppBar

        bottomNavigationView.background = null
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        fabButton.setOnClickListener {
            navController.navigate(R.id.homePageFragment)
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            when (destination.id) {
                R.id.homePageFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.HOME)
                }
                R.id.latestActivityFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.OFFERS)
                }
                R.id.menuFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MENU)
                }
                R.id.profileFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.PROFILE)
                }
                R.id.moreFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MORE)
                }
                R.id.dessertFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MENU)
                }
                R.id.orderFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MENU)
                }
                else -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.OTHER)
                }
            }
        }

        // Observe to Update Bottom Navigation Selection
        viewModel.eventListener.selectBottomNavigationItem.observe(this) { item ->

            // By default Bottom Navigation is not Visible
            binding.coordinatorLayout.visibility = View.GONE

            // Rest FAB Color
            fabButton.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.grey))

            // Reset checkable of Bottom Navigation
            for (i in 0..4) {
                bottomNavigationView.menu.getItem(i).isCheckable = true
            }

            when (item) {
                EventListener.BottomNavigation.HOME -> {

                    // Make Bottom Navigation Visible
                    binding.coordinatorLayout.visibility = View.VISIBLE

                    // Update FAB as Selected
                    fabButton.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(this, R.color.orange))
                    // Update Checkable to false for Home Fragment
                    for (i in 0..4) {
                        bottomNavigationView.menu.getItem(i).isCheckable = false
                    }
                }
                EventListener.BottomNavigation.MENU -> {
                    // Make Bottom Navigation Visible
                    binding.coordinatorLayout.visibility = View.VISIBLE

                }
                EventListener.BottomNavigation.PROFILE -> {
                    // Make Bottom Navigation Visible
                    binding.coordinatorLayout.visibility = View.VISIBLE

                }
                EventListener.BottomNavigation.MORE -> {
                    // Make Bottom Navigation Visible
                    binding.coordinatorLayout.visibility = View.VISIBLE

                }
                EventListener.BottomNavigation.OFFERS -> {
                    // Make Bottom Navigation Visible
                    binding.coordinatorLayout.visibility = View.VISIBLE

                }
                EventListener.BottomNavigation.OTHER -> {
                    // Make Bottom Navigation Invisible
                    binding.coordinatorLayout.visibility = View.GONE
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}