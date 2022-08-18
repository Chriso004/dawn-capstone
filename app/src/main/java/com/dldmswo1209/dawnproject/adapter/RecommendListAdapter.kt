package com.dldmswo1209.dawnproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dldmswo1209.dawnproject.dataClass.TodaySaleItem
import com.dldmswo1209.dawnproject.databinding.RecommendItemBinding

class RecommendListAdapter: ListAdapter<TodaySaleItem, RecommendListAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: RecommendItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(todaySaleItem: TodaySaleItem){
            binding.imageView.setImageResource(todaySaleItem.image)
            binding.brandTextView.text = todaySaleItem.brand
            binding.detailTextView.text = todaySaleItem.detail
            binding.saleTextView.text = todaySaleItem.sale
            binding.priceTextView.text = todaySaleItem.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(RecommendItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<TodaySaleItem>(){
            override fun areItemsTheSame(oldItem: TodaySaleItem, newItem: TodaySaleItem): Boolean {
                return oldItem.brand == newItem.brand
            }

            override fun areContentsTheSame(oldItem: TodaySaleItem, newItem: TodaySaleItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}