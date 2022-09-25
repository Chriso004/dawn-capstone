package com.dldmswo1209.dawnproject.topMenuFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.LikeMenuFragment.LikeCodyFragment
import com.dldmswo1209.dawnproject.LikeMenuFragment.LikeProductFragment
import com.dldmswo1209.dawnproject.LikeMenuFragment.LikeStoreFragment
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentLikeTopBarBinding
import com.google.android.material.tabs.TabLayout


class LikeTopBarFragment : Fragment(R.layout.fragment_like_top_bar) {
    private lateinit var binding : FragmentLikeTopBarBinding
    private lateinit var likeCodyFragment: LikeCodyFragment
    private lateinit var likeProductFragment: LikeProductFragment
    private lateinit var likeStoreFragment: LikeStoreFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLikeTopBarBinding.bind(view)

        initFragment()
        mainTabSelectListener()
    }

    private fun initFragment(){
        likeCodyFragment = LikeCodyFragment()
        likeProductFragment = LikeProductFragment()
        likeStoreFragment = LikeStoreFragment()
        if(!(activity as MainActivity).isMotionAnimating){
            (activity as MainActivity).endMotion()
        }
        (activity as MainActivity).mainFragmentReplace(likeProductFragment)
    }
    private fun mainTabSelectListener(){
        binding.MainTab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0->(activity as MainActivity).mainFragmentReplace(likeProductFragment)
                    1->(activity as MainActivity).mainFragmentReplace(likeStoreFragment)
                    2->(activity as MainActivity).mainFragmentReplace(likeCodyFragment)
                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}