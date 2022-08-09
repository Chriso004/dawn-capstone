package com.dldmswo1209.dawnproject.topFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentTopBarBinding
import com.dldmswo1209.dawnproject.MainTopMenuItems.*
import com.google.android.material.tabs.TabLayout


class MainTopBarFragment : Fragment(R.layout.fragment_top_bar) {
    private lateinit var binding : FragmentTopBarBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var bestFragment: BestFragment
    private lateinit var recommendFragment: RecommendFragment
    private lateinit var codyFragment: CodyFragment
    private lateinit var brandFragment: BrandFragment
    private lateinit var shopFragment: ShopFragment
    private lateinit var saleFragment: SaleFragment
    private lateinit var newProductFragment: NewProductFragment
    private lateinit var eventFragment: EventFragment
    private lateinit var storeFragment: StoreFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopBarBinding.bind(view)
        homeFragment = HomeFragment()
        bestFragment = BestFragment()
        recommendFragment = RecommendFragment()
        codyFragment = CodyFragment()
        brandFragment = BrandFragment()
        shopFragment = ShopFragment()
        saleFragment = SaleFragment()
        newProductFragment = NewProductFragment()
        eventFragment = EventFragment()
        storeFragment = StoreFragment()

        (activity as MainActivity).mainFragmentReplace(homeFragment)

        binding.MainTab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 ->{
                        (activity as MainActivity).mainFragmentReplace(homeFragment)
                    }
                    1 ->{
                        (activity as MainActivity).mainFragmentReplace(bestFragment)
                    }
                    2 ->{
                        (activity as MainActivity).mainFragmentReplace(recommendFragment)
                    }
                    3 ->{
                        (activity as MainActivity).mainFragmentReplace(codyFragment)
                    }
                    4 ->{
                        (activity as MainActivity).mainFragmentReplace(brandFragment)
                    }
                    5 ->{
                        (activity as MainActivity).mainFragmentReplace(shopFragment)
                    }
                    6 ->{
                        (activity as MainActivity).mainFragmentReplace(saleFragment)
                    }
                    7 -> {
                        (activity as MainActivity).mainFragmentReplace(newProductFragment)
                    }
                    8 ->{
                        (activity as MainActivity).mainFragmentReplace(eventFragment)
                    }
                    9 ->{
                        (activity as MainActivity).mainFragmentReplace(storeFragment)
                    }

                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }

}