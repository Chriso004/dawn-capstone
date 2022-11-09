package com.dldmswo1209.dawnproject.MainMenuFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.MainActivity
import com.dldmswo1209.dawnproject.ProductDetailFragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.model.ProductItem
import com.dldmswo1209.dawnproject.databinding.FragmentTodaySaleBinding

class TodaySaleFragment(val items: MutableList<ProductItem>) : Fragment(R.layout.fragment_today_sale) {
    private lateinit var binding: FragmentTodaySaleBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTodaySaleBinding.bind(view)

        binding.apply {
            item1ImageView.setImageResource(items[0].image)
            item1BrandTextView.text = items[0].brand
            item1DetailTextView.text = items[0].detail
            item1SaleTextView.text = items[0].sale
            item1PriceTextView.text = items[0].price

            item2ImageView.setImageResource(items[1].image)
            item2BrandTextView.text = items[1].brand
            item2DetailTextView.text = items[1].detail
            item2SaleTextView.text = items[1].sale
            item2PriceTextView.text = items[1].price

            item3ImageView.setImageResource(items[2].image)
            item3BrandTextView.text = items[2].brand
            item3DetailTextView.text = items[2].detail
            item3SaleTextView.text = items[2].sale
            item3PriceTextView.text = items[2].price

            item3ImageView.setImageResource(items[3].image)
            item3BrandTextView.text = items[3].brand
            item3DetailTextView.text = items[3].detail
            item3SaleTextView.text = items[3].sale
            item3PriceTextView.text = items[3].price

            root.setOnClickListener {
                for(fragment: Fragment in (activity as MainActivity).mainFragment) {
                    if (fragment.isVisible) {
                        // 코드 입력
                        (activity as MainActivity).previousFragment = fragment
                    }
                }
                (activity as MainActivity).mainFragmentReplace(ProductDetailFragment())
                (activity as MainActivity).bottomNavigationStartMotion()
                (activity as MainActivity).topTabStartMotion()
                (activity as MainActivity).startMotion()
            }
        }


    }
}