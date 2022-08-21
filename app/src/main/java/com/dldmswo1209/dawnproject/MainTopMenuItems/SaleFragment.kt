package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.*
import com.dldmswo1209.dawnproject.dataClass.*
import com.dldmswo1209.dawnproject.databinding.FragmentSaleBinding
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.PageStyle
import kotlin.math.absoluteValue

class SaleFragment : Fragment(R.layout.fragment_sale) {
    private lateinit var mViewPager: BannerViewPager<ProductItem>
    private lateinit var mViewPager2: BannerViewPager<BannerItem>
    private lateinit var binding: FragmentSaleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSaleBinding.bind(view)

        val brandSaleAdapter1 = RecommendProductListAdapter()
        val moreRecommendAdapter = BestProductListAdapter()
        brandSaleAdapter1.submitList(recommendList)
        moreRecommendAdapter.submitList(productRankList)
        setupViewPager(binding.root)

        val gridLayoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)

        binding.brandSaleRecyclerView1.adapter = brandSaleAdapter1
        binding.brandSaleRecyclerView2.adapter = brandSaleAdapter1
        binding.brandSaleRecyclerView3.adapter = brandSaleAdapter1
        binding.shopSaleRecyclerView1.adapter = brandSaleAdapter1
        binding.shopSaleRecyclerView2.adapter = brandSaleAdapter1
        binding.shopSaleRecyclerView3.adapter = brandSaleAdapter1
        binding.moreRecommendRecyclerView.apply {
            layoutManager = gridLayoutManager
            adapter = moreRecommendAdapter
        }




    }
    private fun setupViewPager(view: View) {

        mViewPager = view.findViewById(R.id.todaySaleBannerViewPager)
        mViewPager.apply {
            adapter = SaleBannerPagerAdapter()
            setLifecycleRegistry(lifecycle)
            setPageStyle(PageStyle.MULTI_PAGE_SCALE)
            setRevealWidth(250)
            addPageTransformer { page, position ->
                when{
                    position.absoluteValue >= 1F -> { // 다음 페이지로 넘어감
                        page.alpha = 0.5F
                    }
                    position == 0F -> { // 화면의 정중앙
                        page.alpha = 1F
                    }
                    else ->{  // 현재 페이지와 다음 페이지의 중간(스크롤 중)
                        page.alpha = 1F - 0.5F * position.absoluteValue
                    }
                }
            }

        }.create(saleItems1)

        mViewPager2 = view.findViewById(R.id.secondSaleBannerViewPager)
        mViewPager2.apply {
            adapter = SecondSaleBannerPagerAdapter()
            setLifecycleRegistry(lifecycle)
            setPageStyle(PageStyle.MULTI_PAGE_OVERLAP)
        }.create(bannerImages2)
    }
    override fun onPause() {
        if (mViewPager != null) mViewPager.stopLoop()
        if (mViewPager2 != null) mViewPager2.stopLoop()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        if (mViewPager != null) mViewPager.startLoop()
        if (mViewPager2 != null) mViewPager2.startLoop()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mViewPager != null) mViewPager.stopLoop()
        if (mViewPager2 != null) mViewPager2.stopLoop()
    }

}