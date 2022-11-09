package com.dldmswo1209.dawnproject.adapter

import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dldmswo1209.dawnproject.databinding.DetailContentItemBinding
import kotlin.math.roundToInt


class DetailContentAdapter: ListAdapter<Int, DetailContentAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: DetailContentItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(image : Int){
            binding.imageView.setImageResource(image)
            if(adapterPosition == currentList.size-1){ // 마지막 아이템 마진 없애기
                // 아래와 같이 해줘야 기기에 맞는 DP가 나온다.
                val dm: DisplayMetrics = binding.root.resources.displayMetrics
//                val size = (20 * dm.density).roundToInt()
                //마진을 쓸려면  아래와 같은 방법을 쓰면 된다.

                val param = LinearLayoutCompat.LayoutParams(
                    LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                    LinearLayoutCompat.LayoutParams.WRAP_CONTENT)
                param.topMargin = 0
                binding.imageView.layoutParams = param
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DetailContentItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<Int>(){
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
                return oldItem == newItem
            }
        }
    }
}