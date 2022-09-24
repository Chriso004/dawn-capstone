package com.dldmswo1209.dawnproject.adapter

import android.widget.ImageView
import android.widget.TextView
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.model.ProductItem
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

class SaleBannerPagerAdapter : BaseBannerAdapter<ProductItem>() {
    override fun bindData(holder: BaseViewHolder<ProductItem>, data: ProductItem?, position: Int, pageSize: Int) {
        val imageView = holder.findViewById<ImageView>(R.id.bannerImageView)
        val brandTextView = holder.findViewById<TextView>(R.id.brandTextView)
        val detailTextView = holder.findViewById<TextView>(R.id.detailTextView)
        val saleTextView = holder.findViewById<TextView>(R.id.saleTextView)
        val priceTextView = holder.findViewById<TextView>(R.id.priceTextView)

        imageView.setImageResource(data!!.image)
        brandTextView.text = data!!.brand
        detailTextView.text = data!!.detail
        saleTextView.text = data!!.sale
        priceTextView.text = data!!.price

    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.sale_banner_item
    }
}