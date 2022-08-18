package com.dldmswo1209.dawnproject.MainTopMenuItems

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.adapter.TodaySaleViewPagerAdapter
import com.dldmswo1209.dawnproject.dataClass.TodaySaleItem
import com.dldmswo1209.dawnproject.databinding.FragmentTodaySaleBinding

class TodaySaleFragment(val items: MutableList<TodaySaleItem>) : Fragment(R.layout.fragment_today_sale) {
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
        }


    }
}