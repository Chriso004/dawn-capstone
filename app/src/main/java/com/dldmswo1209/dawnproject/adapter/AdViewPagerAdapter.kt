package com.dldmswo1209.dawnproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.MainTopMenuItems.HomeBannerFragment
import com.dldmswo1209.dawnproject.R
import java.net.URI

class AdViewPagerAdapter(
    fragmentActivity: FragmentActivity,
): FragmentStateAdapter(fragmentActivity) {
    val images = arrayOf(
        R.drawable.test_ad1,
        R.drawable.test_ad2,
        R.drawable.test_ad3,
    )
    override fun getItemCount(): Int = images.size

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeBannerFragment(images[0])
            1 -> HomeBannerFragment(images[1])
            else -> HomeBannerFragment(images[2])
        }
    }
}