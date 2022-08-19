package com.dldmswo1209.dawnproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dldmswo1209.dawnproject.databinding.HomeBannerItemBinding

class BannerPagerAdapter(
    private val bannerImages: MutableList<Int>,
    private val viewPager2: ViewPager2
): RecyclerView.Adapter<BannerPagerAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: HomeBannerItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(image: Int){
            binding.bannerImageView.setImageResource(image)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HomeBannerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bannerImages[position])
        if(position == bannerImages.size-1){
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
    private val runnable = Runnable { bannerImages.addAll(bannerImages) }
}