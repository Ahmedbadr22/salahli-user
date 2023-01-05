package com.ahmedbadr.sala7li.presentation.fragments.splashScreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ahmedbadr.sala7li.R
import com.ahmedbadr.sala7li.app.constants.ApplicationConstants

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.myLooper()!!).postDelayed({
            navigateToOnBoardingScreen()
        }, ApplicationConstants.SPLASH_TIME)
    }

    private fun navigateToOnBoardingScreen() {
        val navAction = SplashScreenFragmentDirections.actionSplashScreenFragmentToSignInFragment()
        findNavController().navigate(navAction)
    }

}