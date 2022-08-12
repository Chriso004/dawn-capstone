package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentHomeBannerBinding

class HomeBannerFragment(private var image: Int) : Fragment(R.layout.fragment_home_banner) {
    private lateinit var binding: FragmentHomeBannerBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBannerBinding.bind(view)

        binding.adImageView.setImageResource(image)

    }
}