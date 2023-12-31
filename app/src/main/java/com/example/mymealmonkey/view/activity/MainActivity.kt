package com.example.mymealmonkey.view.activity


import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.ActivityMainBinding
import com.example.mymealmonkey.model.AppViewModel
import com.example.mymealmonkey.utils.EventListener
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // View Model Initiated
    val viewModel: AppViewModel by viewModels()

    // For Binding components
    private lateinit var binding: ActivityMainBinding

    // Navigation Controller
    private lateinit var navController: NavController

    companion object {
        const val TOKEN = "TOKEN"
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        // Setting Theme After Splash Screen
        setTheme(R.style.Theme_MyMealMonkey)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide Notification Bar
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Hide Action Bar
        supportActionBar?.hide()

        // Hide Background of the Bottom Navigation
        binding.bottomNavigationView.background = null


        // Setting Navigation Graph
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Setting Navigation Controller for Navigation through Navigation Graph
        binding.bottomNavigationView.setupWithNavController(navController)

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task: Task<String?> ->
            if (!task.isSuccessful) {
                Log.d(TOKEN, getString(R.string.token_not_received))
                return@addOnCompleteListener
            }
            val token: String? = task.result
            if (token != null) {
                Log.d(TOKEN, token)
            }
        }

        // ClickListeners
        clickListener()

        // Observe the Actions
        observers()

    }

    // For Navigating to Previous Fragment
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    /**
     * Listens to Users Clicks
     */
    private fun clickListener() {
        binding.fabButton.setOnClickListener {

            navController.navigate(R.id.homePageFragment)
        }
    }

    /**
     * Listens the Actions
     */
    private fun observers() {
        // Observe the Destination and Apply Settings Accordingly to the Fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->

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

                R.id.myOrderFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MORE)
                }

                R.id.paymentDetailsFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MORE)
                }

                R.id.notificationsFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MORE)
                }

                R.id.inboxFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MORE)
                }

                R.id.aboutUsFragment -> {
                    viewModel.eventListener.selectBottomNavigationItem(EventListener.BottomNavigation.MORE)
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
            binding.fabButton.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.grey))

            when (item) {
                EventListener.BottomNavigation.HOME -> {

                    // Make Bottom Navigation Visible
                    binding.coordinatorLayout.visibility = View.VISIBLE

                    // Update FAB as Selected
                    binding.fabButton.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(this, R.color.orange))

                    // Update Checked to 2nd item which is disabled to have fb as checked
                    binding.bottomNavigationView.menu.getItem(2).isChecked = true
                }

                EventListener.BottomNavigation.MENU -> {
                    // Make Bottom Navigation Visible
                    binding.coordinatorLayout.visibility = View.VISIBLE
                }

                EventListener.BottomNavigation.PROFILE -> {
                    binding.coordinatorLayout.visibility = View.VISIBLE
                }

                EventListener.BottomNavigation.MORE -> {
                    binding.coordinatorLayout.visibility = View.VISIBLE
                }

                EventListener.BottomNavigation.OFFERS -> {
                    binding.coordinatorLayout.visibility = View.VISIBLE
                }

                EventListener.BottomNavigation.OTHER -> {
                    binding.coordinatorLayout.visibility = View.GONE
                }
            }
        }
    }
}