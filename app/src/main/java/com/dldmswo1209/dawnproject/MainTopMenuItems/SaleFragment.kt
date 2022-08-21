package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.SaleBannerPagerAdapter
import com.dldmswo1209.dawnproject.dataClass.ProductItem
import com.dldmswo1209.dawnproject.dataClass.saleItems1
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.PageStyle
import kotlin.math.absoluteValue

class SaleFragment : Fragment(R.layout.fragment_sale) {
    private lateinit var mViewPager: BannerViewPager<ProductItem>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupViewPager(view)

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
    }
    override fun onPause() {
        if (mViewPager != null) mViewPager.stopLoop()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        if (mViewPager != null) mViewPager.startLoop()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mViewPager != null) mViewPager.stopLoop()
    }

}