package com.dldmswo1209.dawnproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dldmswo1209.dawnproject.model.CodyRankItem
import com.dldmswo1209.dawnproject.databinding.BrandCodyRankItemBinding


class CodyRankListAdapter: ListAdapter<CodyRankItem,CodyRankListAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: BrandCodyRankItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(codyRankItem :CodyRankItem){
            binding.imageView.setImageResource(codyRankItem.image)
            binding.brandTextView.text = codyRankItem.brand
            binding.tagTextView.text = codyRankItem.tag
            binding.thumbButton.isChecked = codyRankItem.like
            binding.thumbButton.isChecked = codyRankItem.like
            binding.thumbButton.setOnClickListener {
                currentList[adapterPosition].like = !currentList[adapterPosition].like
                notifyDataSetChanged()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BrandCodyRankItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<CodyRankItem>(){
            override fun areItemsTheSame(oldItem: CodyRankItem, newItem: CodyRankItem): Boolean {
                return oldItem.brand == newItem.brand
            }

            override fun areContentsTheSame(oldItem: CodyRankItem, newItem: CodyRankItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}