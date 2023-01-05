package com.ahmedbadr.sala7li.presentation.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ahmedbadr.sala7li.R
import com.ahmedbadr.sala7li.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    companion object {
        private val appBarConfigurationBlockedFragments: Set<Int> = setOf(
            R.id.homeFragment,
            // R.id.servicesFragment,
            R.id.ordersFragment,
            R.id.profileFragment
        )
    }

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // get the nested NavHostFragment
        val navHostFragment: NavHostFragment = childFragmentManager.findFragmentById(R.id.mainFragmentContainerView) as NavHostFragment
        // assign the nested NavHostFragment NavController to the variable [navController]
        navController = navHostFragment.navController

        // this variable [appBarConfiguration]
        val appBarConfiguration = AppBarConfiguration(appBarConfigurationBlockedFragments)

        binding.apply {
            // setup the mainBottomNavigation with the navigation Controller
            mainBottomNavigation.setupWithNavController(navController)
            topAppBarMain.apply {
                // setup the topAppBarMain with the navigation Controller and block [appBarConfiguration] fragments to show in the appBar
                setupWithNavController(navController, appBarConfiguration)

                // listen to menu item clicking
                setOnMenuItemClickListener { menuItem ->
                    onMenuItemSelected(menuItem)
                    true
                }
            }


            /***
             * on Navigate using bottom nav controller check if the destination is home fragment or not
             * if home fragment update the topAppBarMain to hold user first name and subtitle
             * else display the fragment Name in the title and center it
             */
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.homeFragment -> {
                        topAppBarMain.apply {
                            title = getString(R.string.app_name)
                            subtitle = getString(R.string.you_can_request_a_technician_now)
                            isTitleCentered = false
                        }
                    }
                    else -> {
                        topAppBarMain.apply {
                            subtitle = ""
                            isTitleCentered = true
                        }
                    }
                }
            }
        }

    }

    /***
     * on topAppBarMain menu item selected navigate to the related fragment
     */
    private fun onMenuItemSelected(menuItem: MenuItem) {
        val navAction: NavDirections = when (menuItem.itemId) {
            R.id.notificationFragment -> MainFragmentDirections.actionMainFragmentToNotificationFragment()
            R.id.searchFragment -> MainFragmentDirections.actionMainFragmentToSearchFragment()
            else -> return
        }
        findNavController().navigate(navAction)
    }

}