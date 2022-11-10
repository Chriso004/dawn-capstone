package com.dldmswo1209.dawnproject.topMenuFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentTopBarBinding
import com.dldmswo1209.dawnproject.MainMenuFragment.*
import com.google.android.material.tabs.TabLayout


class MainTopBarFragment : Fragment(R.layout.fragment_top_bar) {
    private lateinit var binding : FragmentTopBarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopBarBinding.bind(view)
        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).homeFragment)
        mainTabSelectListener()

    }
    private fun mainTabSelectListener(){
        binding.MainTab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).homeFragment)
                    }
                    1 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).bestFragment)
                    }
                    2 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).recommendFragment)
                    }
                    3 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).codyFragment)
                    }
                    4 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).brandFragment)
                    }
                    5 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).shopFragment)
                    }
                    6 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).saleFragment)
                    }
                    7 -> {
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).newProductFragment)
                    }
                    8 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).eventFragment)
                    }
                    9 ->{
                        (activity as MainActivity).mainFragmentReplace((activity as MainActivity).storeFragment)
                    }

                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }


}