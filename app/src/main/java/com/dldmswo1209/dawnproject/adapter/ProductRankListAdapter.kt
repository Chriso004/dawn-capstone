package com.dldmswo1209.dawnproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dldmswo1209.dawnproject.dataClass.ProductItem
import com.dldmswo1209.dawnproject.databinding.ProductRankItemBinding

class ProductRankListAdapter: ListAdapter<ProductItem, ProductRankListAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: ProductRankItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(productItem: ProductItem){
            binding.itemImageView.setImageResource(productItem.image)
            binding.brandTextView.text = productItem.brand
            binding.detailTextView.text = productItem.detail
            binding.saleTextView.text = productItem.sale
            binding.priceTextView.text = productItem.price
            binding.likeButton.isChecked = productItem.like
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(ProductRankItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<ProductItem>(){
            override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
                return oldItem.brand == newItem.brand
            }

            override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}