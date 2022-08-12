package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.AdViewPagerAdapter
import com.dldmswo1209.dawnproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val adapter = AdViewPagerAdapter(requireActivity())
        binding.mainAdImageViewPager.adapter = adapter

    }
}