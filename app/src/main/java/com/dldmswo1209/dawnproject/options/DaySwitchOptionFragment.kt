package com.dldmswo1209.dawnproject.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentBrandShopOptionBinding
import com.dldmswo1209.dawnproject.databinding.FragmentDaySwitchOptionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DaySwitchOptionFragment(val itemClick: (Int) -> Unit) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDaySwitchOptionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_day_switch_option, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDaySwitchOptionBinding.bind(view)

        binding.day.setOnClickListener {
            itemClick(0)
            dialog?.dismiss()
        }
        binding.week.setOnClickListener {
            itemClick(1)
            dialog?.dismiss()
        }
        binding.month.setOnClickListener {
            itemClick(2)
            dialog?.dismiss()
        }

    }
}