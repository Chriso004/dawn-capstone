package com.dldmswo1209.dawnproject.topMenuFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentMyPageBinding
import com.dldmswo1209.dawnproject.databinding.FragmentMyPageTopBarBinding
import com.dldmswo1209.dawnproject.databinding.FragmentTopBarBinding

class MyPageTopBarFragment : Fragment(R.layout.fragment_my_page_top_bar) {
    private lateinit var binding: FragmentMyPageTopBarBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageTopBarBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(!(activity as MainActivity).isMotionAnimating){
            Log.d("testt","yes")
            (activity as MainActivity).endMotion()
        }else{
            Log.d("testt","no..")
        }

    }
}