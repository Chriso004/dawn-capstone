package com.dldmswo1209.dawnproject

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.adapter.BannerPagerAdapter
import com.dldmswo1209.dawnproject.databinding.FragmentProductDetailBinding
import com.dldmswo1209.dawnproject.model.detailImage

class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private val sliderImageHandler: Handler = Handler(Looper.getMainLooper())
    private val sliderImageRunnable = Runnable { binding.ImageViewPager.currentItem = binding.ImageViewPager.currentItem + 1 }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            (activity as MainActivity).mainFragmentReplace((activity as MainActivity).previousFragment)
        }

        val viewPagerAdapter = BannerPagerAdapter(detailImage, binding.ImageViewPager)

        binding.ImageViewPager.apply {
            adapter = viewPagerAdapter
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

        binding.buyButton.setOnClickListener {

        }


    }


    override fun onDetach() {
        (activity as MainActivity).bottomNavigationEndMotion()
        (activity as MainActivity).topTabEndMotion()
        super.onDetach()
    }

}