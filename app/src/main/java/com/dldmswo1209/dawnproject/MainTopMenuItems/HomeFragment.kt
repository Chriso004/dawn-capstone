package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.AdViewPagerAdapter
import com.dldmswo1209.dawnproject.adapter.HomeCategoryListAdapter
import com.dldmswo1209.dawnproject.adapter.TodaySaleViewPagerAdapter
import com.dldmswo1209.dawnproject.dataClass.CategoryItem
import com.dldmswo1209.dawnproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val categoryList = mutableListOf<CategoryItem>(
        CategoryItem(R.drawable.image_box, "전체"),
        CategoryItem(R.drawable.image_box, "상의"),
        CategoryItem(R.drawable.image_box, "하의"),
        CategoryItem(R.drawable.image_box, "아우터"),
        CategoryItem(R.drawable.image_box, "신발"),
        CategoryItem(R.drawable.image_box, "스커트"),
        CategoryItem(R.drawable.image_box, "원피스"),
        CategoryItem(R.drawable.image_box, "가방"),

    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val adViewPagerAdapter = AdViewPagerAdapter(requireActivity())
        val categoryListAdapter = HomeCategoryListAdapter()
        val todaySalePagerAdapter = TodaySaleViewPagerAdapter(requireActivity())
        categoryListAdapter.submitList(categoryList)

        binding.mainAdImageViewPager.adapter = adViewPagerAdapter
        binding.categoryRecyclerView.adapter = categoryListAdapter
        binding.todaySaleViewPager.adapter = todaySalePagerAdapter

        binding.totalPage.text = todaySalePagerAdapter.itemCount.toString()
        binding.todaySaleViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.currentPage.text = "${position+1}"
            }
        })


    }
}