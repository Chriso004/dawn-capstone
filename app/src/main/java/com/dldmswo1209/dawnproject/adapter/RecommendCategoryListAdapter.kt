package com.dldmswo1209.dawnproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dldmswo1209.dawnproject.dataClass.CategoryItem
import com.dldmswo1209.dawnproject.databinding.RecommendCategoryItemBinding


class RecommendCategoryListAdapter: ListAdapter<CategoryItem,RecommendCategoryListAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: RecommendCategoryItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(categoryItem :CategoryItem){
            binding.brandTitleTextView.text = categoryItem.categoryText
            binding.brandImage.setImageResource(categoryItem.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecommendCategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<CategoryItem>(){
            override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
                return oldItem.categoryText == newItem.categoryText
            }

            override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}