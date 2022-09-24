package com.dldmswo1209.dawnproject.adapter

import android.widget.ImageView
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.model.BannerItem
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

class SecondSaleBannerPagerAdapter : BaseBannerAdapter<BannerItem>() {
    override fun bindData(holder: BaseViewHolder<BannerItem>, data: BannerItem?, position: Int, pageSize: Int) {
        val imageView = holder.findViewById<ImageView>(R.id.bannerImageView)
        imageView.setImageResource(data!!.image)
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.home_banner_item
    }
}