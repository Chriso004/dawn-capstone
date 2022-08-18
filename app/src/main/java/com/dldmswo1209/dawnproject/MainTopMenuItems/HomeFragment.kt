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
import com.dldmswo1209.dawnproject.adapter.CodyRankListAdapter
import com.dldmswo1209.dawnproject.adapter.HomeCategoryListAdapter
import com.dldmswo1209.dawnproject.adapter.TodaySaleViewPagerAdapter
import com.dldmswo1209.dawnproject.dataClass.CategoryItem
import com.dldmswo1209.dawnproject.dataClass.CodyRankItem
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
    private val codyRankList = mutableListOf(
        CodyRankItem(R.drawable.brand_test_image1, "드로우핏","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩"),
        CodyRankItem(R.drawable.brand_test_image2, "꼼파늘","#홈웨어 #캐주얼 #일상룩 #페미닌 #유니크"),
        CodyRankItem(R.drawable.brand_test_image3, "라퍼지스토어","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩"),
        CodyRankItem(R.drawable.brand_test_image1, "나이키","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩"),
        CodyRankItem(R.drawable.brand_test_image2, "앤더슨벨","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩"),
        CodyRankItem(R.drawable.brand_test_image3, "Cos","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩"),
        CodyRankItem(R.drawable.brand_test_image2, "수아레","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩"),
        CodyRankItem(R.drawable.brand_test_image1, "파르티멘토","#캠퍼스룩 #캐주얼 #여행룩 #데이트룩 #일상룩"),

    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val adViewPagerAdapter = AdViewPagerAdapter(requireActivity())
        val categoryListAdapter = HomeCategoryListAdapter()
        val todaySalePagerAdapter = TodaySaleViewPagerAdapter(requireActivity())
        val codyRankListAdapter = CodyRankListAdapter()

        codyRankListAdapter.submitList(codyRankList)
        categoryListAdapter.submitList(categoryList)

        binding.mainAdImageViewPager.adapter = adViewPagerAdapter
        binding.categoryRecyclerView.adapter = categoryListAdapter
        binding.brandCodyRankRecyclerView.adapter = codyRankListAdapter
        binding.todaySaleViewPager.adapter = todaySalePagerAdapter

        binding.totalPage.text = todaySalePagerAdapter.itemCount.toString()
        binding.todaySaleViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.currentPage.text = "${position+1}"
            }
        })
        binding.brandCodyRankRecyclerView


    }
}