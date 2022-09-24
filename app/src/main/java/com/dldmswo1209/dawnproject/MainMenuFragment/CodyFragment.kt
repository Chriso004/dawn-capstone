package com.dldmswo1209.dawnproject.MainMenuFragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.BannerPagerAdapter
import com.dldmswo1209.dawnproject.adapter.CodyListAdapter
import com.dldmswo1209.dawnproject.model.bannerImages
import com.dldmswo1209.dawnproject.model.codyRankList
import com.dldmswo1209.dawnproject.databinding.FragmentCodyBinding
import com.dldmswo1209.dawnproject.options.CodyFilterFragment

class CodyFragment : Fragment(R.layout.fragment_cody) {
    private lateinit var binding: FragmentCodyBinding
    private val sliderImageHandler: Handler = Handler()
    private val sliderImageRunnable = Runnable { binding.codyAdViewPager.currentItem = binding.codyAdViewPager.currentItem + 1 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCodyBinding.bind(view)
        val bannerPagerAdapter = BannerPagerAdapter(bannerImages, binding.codyAdViewPager)
        val codyListAdapter = CodyListAdapter()

        codyListAdapter.submitList(codyRankList)

        binding.codyAdViewPager.apply {
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

        val gridLayoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        binding.codyRecyclerView.apply {
            adapter = codyListAdapter
            layoutManager = gridLayoutManager
        }

        binding.codyCategoryFilterButton.setOnClickListener {
            val codyFilterFragment = CodyFilterFragment{ classCheckedId, sortCheckedId, styleList ->
                var filterStr = ""
                when(classCheckedId){
                    R.id.all -> filterStr += "전체/"
                    R.id.brand -> filterStr += "브랜드/"
                    R.id.shop -> filterStr += "쇼핑몰/"
                }
                when(sortCheckedId){
                    R.id.popular -> filterStr += "인기순/"
                    R.id.newProduct -> filterStr += "최신순/"
                }
                filterStr += "스타일(${styleList.size})"
                binding.filterName.text = filterStr
            }
            codyFilterFragment.show(parentFragmentManager, codyFilterFragment.tag)
        }

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