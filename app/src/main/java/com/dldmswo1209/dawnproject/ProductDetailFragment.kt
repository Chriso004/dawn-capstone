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
import com.dldmswo1209.dawnproject.adapter.*
import com.dldmswo1209.dawnproject.databinding.FragmentProductDetailBinding
import com.dldmswo1209.dawnproject.model.codyRankList
import com.dldmswo1209.dawnproject.model.detailImage
import com.dldmswo1209.dawnproject.model.productRankList

class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding

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
        val codyAdapter = DetailCodyAdapter()
        val contentAdapter = DetailContentAdapter()
        val recommendAdapter = ProductRankListAdapter{}
        val recommendAdapter2 = ProductRankListAdapter{}
        codyAdapter.submitList(codyRankList)
        contentAdapter.submitList(detailImage)
        recommendAdapter.submitList(productRankList)
        recommendAdapter2.submitList(productRankList)

        binding.codyRecyclerView.adapter = codyAdapter
        binding.ContentImageRecyclerView.adapter = contentAdapter
        binding.recommendRecyclerView.adapter = recommendAdapter
        binding.recommendRecyclerView2.adapter = recommendAdapter2

        binding.ImageViewPager.apply {
            adapter = viewPagerAdapter
            offscreenPageLimit = 1 //
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
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