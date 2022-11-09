package com.dldmswo1209.dawnproject.MainMenuFragment

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.BestProductListAdapter
import com.dldmswo1209.dawnproject.adapter.RecommendCategoryListAdapter
import com.dldmswo1209.dawnproject.adapter.RecommendProductListAdapter
import com.dldmswo1209.dawnproject.model.brandList
import com.dldmswo1209.dawnproject.model.productRankList
import com.dldmswo1209.dawnproject.model.shopList
import com.dldmswo1209.dawnproject.databinding.FragmentRecommendBinding

class RecommendFragment : Fragment(R.layout.fragment_recommend) {
    private lateinit var binding: FragmentRecommendBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecommendBinding.bind(view)

        val recommendBrandListAdapter = RecommendCategoryListAdapter()
        val recommendBrandProductListAdapter = RecommendProductListAdapter()
        val recommendShopListAdapter = RecommendCategoryListAdapter()
        val recommendShopProductListAdapter = RecommendProductListAdapter()
        val moreRecommendAdapter = BestProductListAdapter{
            (activity as MainActivity).goProductDetailPage()
        }
        val gridLayoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)

        recommendBrandListAdapter.submitList(brandList)
        recommendBrandProductListAdapter.submitList(productRankList)
        recommendShopListAdapter.submitList(shopList)
        recommendShopProductListAdapter.submitList(productRankList)
        moreRecommendAdapter.submitList(productRankList)


        binding.recommendBrandRecyclerView.adapter = recommendBrandListAdapter
        binding.recommendBrandProductRecyclerView.adapter = recommendBrandProductListAdapter
        binding.recommendShopRecyclerView.adapter = recommendShopListAdapter
        binding.recommendShopProductRecyclerView.adapter = recommendShopProductListAdapter
        binding.moreRecommendRecyclerView.apply {
            adapter = moreRecommendAdapter
            layoutManager = gridLayoutManager
        }

        binding.brandScrollView.viewTreeObserver.addOnScrollChangedListener {
            val context = context ?: return@addOnScrollChangedListener

            if(binding.brandScrollView.scrollY > 150f.dpToPx(context).toInt()){
                // 150px 만큼 스크롤 되면
                if(!(activity as MainActivity).isMotionAnimating){
                    (activity as MainActivity).startMotion()
                }
            }else{ // 150px 만큼 스크롤 되지 않은 경우
                if(!(activity as MainActivity).isMotionAnimating){
                    (activity as MainActivity).endMotion()
                }
            }
        }

    }
    fun Float.dpToPx(context: Context): Float =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics)
}