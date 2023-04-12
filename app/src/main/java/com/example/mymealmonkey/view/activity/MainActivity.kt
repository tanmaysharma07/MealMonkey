package com.example.mymealmonkey.view.activity

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.ActivityMainBinding
import com.example.mymealmonkey.model.AppViewModel
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

        viewModel.eventListener.showBottomNavigationLD.observe(this) {
            if (it) {
                binding.coordinatorLayout.visibility = View.VISIBLE
            } else {
                binding.coordinatorLayout.visibility = View.GONE
            }
        }
        fabButton.setOnClickListener {
            navController.navigate(R.id.homePageFragment)
        }
        bottomNavigationView.menu.getItem(0).isCheckable = false
        bottomNavigationView.menu.getItem(1).isCheckable = false
        bottomNavigationView.menu.getItem(3).isCheckable = false
        bottomNavigationView.menu.getItem(4).isCheckable = false
        viewModel.eventListener.checkable.observe(this) {
            when (it) {
                "Menu" -> bottomNavigationView.menu.getItem(0).isCheckable = true
                "Offers" -> bottomNavigationView.menu.getItem(1).isCheckable = true
                "Profile" -> bottomNavigationView.menu.getItem(3).isCheckable = true
                "More" -> bottomNavigationView.menu.getItem(4).isCheckable = true
                else -> {
                    bottomNavigationView.menu.getItem(0).isCheckable = false
                    bottomNavigationView.menu.getItem(1).isCheckable = false
                    bottomNavigationView.menu.getItem(3).isCheckable = false
                    bottomNavigationView.menu.getItem(4).isCheckable = false
                }
            }
        }
        viewModel.eventListener.fabColor.observe(this) {
            when (it) {
                "Orange" -> fabButton.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.orange))
                "Grey" -> fabButton.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.grey))
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}