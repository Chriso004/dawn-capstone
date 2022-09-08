package com.dldmswo1209.dawnproject.myPage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentMyPageBinding
import com.dldmswo1209.dawnproject.login.LoginActivity
import com.dldmswo1209.dawnproject.login.RegisterMainActivity

class MyPageFragment : Fragment(R.layout.fragment_my_page) {
    private lateinit var binding: FragmentMyPageBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMyPageBinding.bind(view)

        binding.loginButton.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
        binding.registerButton.setOnClickListener {
            startActivity(Intent(requireContext(), RegisterMainActivity::class.java))
        }
    }
}