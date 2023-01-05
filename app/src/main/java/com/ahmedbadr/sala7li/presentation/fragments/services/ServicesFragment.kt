package com.ahmedbadr.sala7li.presentation.fragments.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ahmedbadr.sala7li.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {
    private lateinit var binding: FragmentServicesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity


        binding.apply {
            appCompatActivity.setSupportActionBar(topAppBarServicesToolbar)
            topAppBarServicesToolbar.setupWithNavController(findNavController())
        }
    }

}