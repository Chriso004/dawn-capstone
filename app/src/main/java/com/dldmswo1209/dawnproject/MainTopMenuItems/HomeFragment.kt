package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.*
import com.dldmswo1209.dawnproject.dataClass.*
import com.dldmswo1209.dawnproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val sliderImageHandler: Handler = Handler()
    private val sliderImageRunnable = Runnable { binding.mainAdImageViewPager.currentItem = binding.mainAdImageViewPager.currentItem + 1 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val categoryListAdapter = HomeCategoryListAdapter()
        val todaySalePagerAdapter = TodaySaleViewPagerAdapter(requireActivity())
        val codyRankListAdapter = CodyRankListAdapter()
        val productRankListAdapter = ProductRankListAdapter()
        val recommendListAdapter = RecommendListAdapter()
        val bannerPagerAdapter = BannerPagerAdapter(bannerImages, binding.mainAdImageViewPager)

        codyRankListAdapter.submitList(codyRankList)
        categoryListAdapter.submitList(categoryList)
        productRankListAdapter.submitList(productRankList)
        recommendListAdapter.submitList(recommendList)


        binding.mainAdImageViewPager.apply {
            adapter = bannerPagerAdapter
            offscreenPageLimit = 1 //
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderImageHandler.removeCallbacks(sliderImageRunnable)
                    sliderImageHandler.postDelayed(sliderImageRunnable, 2000)
                }
            })
        }
        binding.categoryRecyclerView.adapter = categoryListAdapter
        binding.brandCodyRankRecyclerView.adapter = codyRankListAdapter
        binding.shopCodyRankRecyclerView.adapter = codyRankListAdapter
        binding.todaySaleViewPager.adapter = todaySalePagerAdapter

        val gridLayoutManager1 = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
        binding.brandProductRankRecyclerView.apply {
            adapter = productRankListAdapter
            layoutManager = gridLayoutManager1
        }
        val gridLayoutManager2 = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
        binding.shopProductRankRecyclerView.apply{
            adapter = productRankListAdapter
            layoutManager = gridLayoutManager2
        }
        val gridLayoutManager3 = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        binding.recommendProductForYouRecyclerView.apply {
            adapter = recommendListAdapter
            layoutManager = gridLayoutManager3
        }

        binding.totalPage.text = todaySalePagerAdapter.itemCount.toString()
        binding.todaySaleViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.currentPage.text = "${position+1}"
            }
        })


    }
    override fun onResume() {
        super.onResume()
        sliderImageHandler.postDelayed(sliderImageRunnable, 1000)
    }

    override fun onPause() {
        super.onPause()
        sliderImageHandler.removeCallbacks(sliderImageRunnable)
    }
}