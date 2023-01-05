package com.ahmedbadr.sala7li.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.ahmedbadr.sala7li.databinding.FragmentHomeBinding
import com.ahmedbadr.sala7li.presentation.fragments.main.MainFragmentDirections

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = parentFragment?.parentFragment?.findNavController()

        binding.apply {
            homeFragment = this@HomeFragment
        }
    }

    fun navigateToAllServicesFragment() {
        navController?.let { controller ->
            val navAction : NavDirections = MainFragmentDirections.actionMainFragmentToServicesFragment()
            controller.navigate(navAction)
        }
    }

}