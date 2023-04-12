package com.example.mymealmonkey.view.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.ActivityMainBinding
import com.example.mymealmonkey.model.AppViewModel
import com.example.mymealmonkey.view.fragment.latestOffers.LatestOffersPageFragment
import com.google.android.material.navigation.NavigationBarView
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
//        val fabButton = binding.fabButton
//        val bottomAppBar = binding.bottomAppBar

        bottomNavigationView.background = null
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)


        viewModel.eventListener.showBottomNavigation.observe(this) {
            if (it) {
                binding.coordinatorLayout.visibility = View.VISIBLE
            } else {
                binding.coordinatorLayout.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}