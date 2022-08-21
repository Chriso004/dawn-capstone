package com.dldmswo1209.dawnproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dldmswo1209.dawnproject.MainTopMenuItems.TodaySaleFragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.dataClass.ProductItem
import com.dldmswo1209.dawnproject.dataClass.saleItems1
import com.dldmswo1209.dawnproject.dataClass.saleItems2

class TodaySaleViewPagerAdapter(
    fragmentActivity: FragmentActivity,
): FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TodaySaleFragment(saleItems1)
            else -> TodaySaleFragment(saleItems2)
        }
    }
}