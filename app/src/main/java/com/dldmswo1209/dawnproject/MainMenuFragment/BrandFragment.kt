package com.dldmswo1209.dawnproject.MainMenuFragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.BannerPagerAdapter
import com.dldmswo1209.dawnproject.databinding.FragmentBrandBinding
import com.dldmswo1209.dawnproject.model.bannerImages
import com.dldmswo1209.dawnproject.model.bannerImages3

class BrandFragment : Fragment(R.layout.fragment_brand) {
    private lateinit var binding : FragmentBrandBinding
    private val sliderImageHandler: Handler = Handler(Looper.getMainLooper())
    private val sliderImageRunnable = Runnable { binding.brandViewPager.currentItem = binding.brandViewPager.currentItem + 1 }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBrandBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bannerPagerAdapter = BannerPagerAdapter(bannerImages3, binding.brandViewPager)
        binding.brandViewPager.apply {
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

    }
}