package com.wngud.coin.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wngud.coin.databinding.ItemCoinBinding
import com.wngud.coin.model.CoinInfo

class CoinListAdapter(private val viewModel: CoinListViewModel) :
    ListAdapter<CoinInfo, CoinListAdapter.CoinListViewHolder>(CoinListDiffCallback()) {

    inner class CoinListViewHolder(private val binding: ItemCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: CoinInfo) {
                binding.tvCoinNameKr.text = item.korean_name
                binding.tvCoinNameEn.text = item.english_name
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder =
        CoinListViewHolder(
            ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        val item = viewModel.coins.value?.get(position)
        if (item != null) {
            holder.bind(item)
        }
    }
}

class CoinListDiffCallback : DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.korean_name == newItem.korean_name
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}