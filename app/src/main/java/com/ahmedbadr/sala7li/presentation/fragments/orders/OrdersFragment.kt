package com.ahmedbadr.sala7li.presentation.fragments.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ahmedbadr.sala7li.R
import com.ahmedbadr.sala7li.app.utils.adapters.ordersTabAdapter.OrdersTabViewPagerAdapter
import com.ahmedbadr.sala7li.databinding.FragmentOrdersBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrdersFragment : Fragment() {
    private lateinit var binding: FragmentOrdersBinding
    private lateinit var tabsNameList: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersBinding.inflate(layoutInflater, container, false)
        tabsNameList = listOf(
            getString(R.string.current),
            getString(R.string.last_orders)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewPagerOrders.adapter = OrdersTabViewPagerAdapter(this@OrdersFragment)

            TabLayoutMediator(tabLayoutOrders, viewPagerOrders) { tab, position ->
                tab.text = tabsNameList[position]
            }.attach()
        }
    }

}