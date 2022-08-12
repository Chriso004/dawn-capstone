package com.dldmswo1209.dawnproject.options

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentAgeOptionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AgeOptionFragment(val itemClick: (Int) -> Unit)
    : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentAgeOptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_age_option, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAgeOptionBinding.bind(view)

        binding.allAge.setOnClickListener {
            itemClick(0)
            dialog?.dismiss()
        }
        binding.under19.setOnClickListener {
            itemClick(1)
            dialog?.dismiss()
        }
        binding.under24.setOnClickListener {
            itemClick(2)
            dialog?.dismiss()
        }
        binding.under29.setOnClickListener {
            itemClick(3)
            dialog?.dismiss()
        }
        binding.up30.setOnClickListener {
            itemClick(4)
            dialog?.dismiss()
        }

    }
}