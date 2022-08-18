package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.*
import com.dldmswo1209.dawnproject.dataClass.CategoryItem
import com.dldmswo1209.dawnproject.dataClass.CodyRankItem
import com.dldmswo1209.dawnproject.dataClass.TodaySaleItem
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
    private val productRankList = mutableListOf(
        TodaySaleItem(R.drawable.test_image,"아디다스","자체제작 / 크롭 후드 트레이닝","23%","76,500"),
        TodaySaleItem(R.drawable.test_image2,"유니클로","제임스 반팔 카라 셔츠","40%","32,900"),
        TodaySaleItem(R.drawable.test_image,"드로우핏","린넨 미니멀 베이지 셔츠","47%","69,900"),
        TodaySaleItem(R.drawable.test_image2,"커버낫","자체제작 / 그레이 페미닌 퓨어...","","47,000"),
        TodaySaleItem(R.drawable.test_image2,"비바스튜디오","자체제작 / 그레이 페미닌 퓨어...","","47,000"),
        TodaySaleItem(R.drawable.test_image2,"아르마니","자체제작 / 그레이 페미닌 퓨어...","","47,000"),
    )
    private val recommendList = mutableListOf(
        TodaySaleItem(R.drawable.recommend_test_image1,"캘빈클라인","[1+3] 이너 나시 4color","23%","76,500"),
        TodaySaleItem(R.drawable.recommend_test_image2,"도프제이슨","크롭 레더 자켓","40%","32,900"),
        TodaySaleItem(R.drawable.recommend_test_image3,"마르디 메크르디","블랙 피스 프린팅 반팔 티셔츠","47%","69,900"),
        TodaySaleItem(R.drawable.recommend_test_image4,"타입서비스","자체제작 / 화이트 오프숄더 크...","","47,000"),
    )
    private val bannerImages = mutableListOf(
        R.drawable.test_ad1,
        R.drawable.test_ad2,
        R.drawable.test_ad3
    )
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
            offscreenPageLimit = 1
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