package com.dldmswo1209.dawnproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dldmswo1209.dawnproject.model.CategoryItem
import com.dldmswo1209.dawnproject.databinding.HomeCategoryItemBinding


class HomeCategoryListAdapter: ListAdapter<CategoryItem,HomeCategoryListAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: HomeCategoryItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(categoryItem :CategoryItem){
            binding.categoryTextView.text = categoryItem.categoryText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HomeCategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
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