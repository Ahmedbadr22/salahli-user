package com.ahmedbadr.sala7li.presentation.fragments.search

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ahmedbadr.sala7li.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appCompatActivity = activity as AppCompatActivity

        val imm: InputMethodManager = appCompatActivity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager



        binding.apply {
            // make the search bar focus on View Created
            textInputEditTextSearch.requestFocus()
            imm.showSoftInput(textInputEditTextSearch, 0)

            appCompatActivity.setSupportActionBar(topAppSearchToolbar)
            topAppSearchToolbar.setupWithNavController(findNavController())
        }


    }

}