package com.dldmswo1209.dawnproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dldmswo1209.dawnproject.MainMenuFragment.TodaySaleFragment
import com.dldmswo1209.dawnproject.model.*

class TodaySaleViewPagerAdapter(
    fragmentActivity: FragmentActivity,
): FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TodaySaleFragment(saleItems1)
            1 -> TodaySaleFragment(saleItems2)
            2 -> TodaySaleFragment(saleItems3)
            3 -> TodaySaleFragment(saleItems4)
            else -> TodaySaleFragment(saleItems5)
        }
    }
}