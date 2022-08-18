package com.dldmswo1209.dawnproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dldmswo1209.dawnproject.MainTopMenuItems.TodaySaleFragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.dataClass.TodaySaleItem

class TodaySaleViewPagerAdapter(
    fragmentActivity: FragmentActivity,
): FragmentStateAdapter(fragmentActivity) {
    val saleItems1 = mutableListOf(
        TodaySaleItem(R.drawable.test_image,"아디다스","자체제작 / 크롭 후드 트레이닝","23%","76,500"),
        TodaySaleItem(R.drawable.test_image2,"유니클로","제임스 반팔 카라 셔츠","40%","32,900"),
        TodaySaleItem(R.drawable.test_image,"드로우핏","린넨 미니멀 베이지 셔츠","47%","69,900"),
        TodaySaleItem(R.drawable.test_image2,"꼼파늘","자체제작 / 그레이 페미닌 퓨어...","","47,000"),
    )
    val saleItems2 = mutableListOf(
        TodaySaleItem(R.drawable.test_image,"테스트입니다.","자체제작 / 크롭 후드 트레이닝","23%","76,500"),
        TodaySaleItem(R.drawable.test_image2,"테스트2","테스트 상세설명 입니다","40%","32,900"),
        TodaySaleItem(R.drawable.test_image,"테스트3","린넨 미니멀 베이지 셔츠","47%","69,900"),
        TodaySaleItem(R.drawable.test_image2,"테스트4","자체제작 / 그레이 페미닌 퓨어...","","47,000"),
    )

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TodaySaleFragment(saleItems1)
            else -> TodaySaleFragment(saleItems2)
        }
    }
}