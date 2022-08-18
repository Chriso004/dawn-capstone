package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentCodyBinding
import com.dldmswo1209.dawnproject.options.AgeOptionFragment
import com.dldmswo1209.dawnproject.options.CodyFilterFragment

class CodyFragment : Fragment(R.layout.fragment_cody) {
    private lateinit var binding: FragmentCodyBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCodyBinding.bind(view)

        binding.codyCategoryFilterButton.setOnClickListener {
            val codyFilterFragment = CodyFilterFragment{ classCheckedId, sortCheckedId, styleList ->
                var filterStr = ""
                when(classCheckedId){
                    R.id.all -> filterStr += "전체/"
                    R.id.brand -> filterStr += "브랜드/"
                    R.id.shop -> filterStr += "쇼핑몰/"
                }
                when(sortCheckedId){
                    R.id.popular -> filterStr += "인기순/"
                    R.id.newProduct -> filterStr += "최신순/"
                }
                filterStr += "스타일(${styleList.size})"
                Toast.makeText(context, filterStr, Toast.LENGTH_SHORT).show()
                binding.filterName.text = filterStr
            }
            codyFilterFragment.show(parentFragmentManager, codyFilterFragment.tag)
        }

    }

}