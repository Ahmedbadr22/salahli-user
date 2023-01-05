package com.ahmedbadr.sala7li.app.utils.adapters.ordersTabAdapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ahmedbadr.sala7li.app.constants.ApplicationConstants.ORDERS_TABS_COUNT
import com.ahmedbadr.sala7li.presentation.fragments.orders.tabs.current.CurrentTabFragment
import com.ahmedbadr.sala7li.presentation.fragments.orders.tabs.last.LastTabFragment

class OrdersTabViewPagerAdapter(
    fragment : Fragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = ORDERS_TABS_COUNT

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CurrentTabFragment()
            1 -> LastTabFragment()
            else -> throw IndexOutOfBoundsException("There is no tab fragment with this index $position")
        }
    }

}