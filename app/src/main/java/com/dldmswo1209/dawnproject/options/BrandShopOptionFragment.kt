package com.dldmswo1209.dawnproject.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentBrandShopOptionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BrandShopOptionFragment(val itemClick: (Int) -> Unit) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBrandShopOptionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_brand_shop_option, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBrandShopOptionBinding.bind(view)

        binding.all.setOnClickListener {
            itemClick(0)
            dialog?.dismiss()
        }
        binding.brand.setOnClickListener {
            itemClick(1)
            dialog?.dismiss()
        }
        binding.shop.setOnClickListener {
            itemClick(2)
            dialog?.dismiss()
        }

    }
}