package com.dldmswo1209.dawnproject.MainMenuFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.ProductDetailFragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.BestProductListAdapter
import com.dldmswo1209.dawnproject.model.productRankList
import com.dldmswo1209.dawnproject.databinding.FragmentBestBinding
import com.dldmswo1209.dawnproject.options.AgeOptionFragment
import com.dldmswo1209.dawnproject.options.BrandShopOptionFragment
import com.dldmswo1209.dawnproject.options.DaySwitchOptionFragment

class BestFragment : Fragment(R.layout.fragment_best) {
    private lateinit var binding: FragmentBestBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_best, container, false)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBestBinding.bind(view)

        val bestProductListAdapter = BestProductListAdapter{
            (activity as MainActivity).goProductDetailPage()
        }
        bestProductListAdapter.submitList(productRankList)
        val gridLayoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        binding.bestRecyclerView.apply {
            adapter = bestProductListAdapter
            layoutManager = gridLayoutManager
        }

        binding.optionAge.setOnClickListener{
            val ageOptionFragment = AgeOptionFragment {
                when (it) {
                    0 -> Toast.makeText(requireContext(), "전체", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(requireContext(), "19세 이하", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(requireContext(), "20~24세", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(requireContext(), "25~29세", Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(requireContext(), "30세 이상", Toast.LENGTH_SHORT).show()
                }
            }
            ageOptionFragment.show(parentFragmentManager, ageOptionFragment.tag)
        }
        binding.optionShopBrand.setOnClickListener {
            val brandShopOptionFragment = BrandShopOptionFragment{
                when(it){
                    0 -> Toast.makeText(requireContext(), "전체", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(requireContext(), "브랜드", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(requireContext(), "쇼핑몰", Toast.LENGTH_SHORT).show()
                }
            }
            brandShopOptionFragment.show(parentFragmentManager, brandShopOptionFragment.tag)
        }
        binding.filterSwitchButton.setOnClickListener{
            val daySwitchOptionFragment = DaySwitchOptionFragment{
                when(it){
                    0 -> Toast.makeText(requireContext(), "일간", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(requireContext(), "주간", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(requireContext(), "월간", Toast.LENGTH_SHORT).show()
                }
            }
            daySwitchOptionFragment.show(parentFragmentManager, daySwitchOptionFragment.tag)
        }

    }

}