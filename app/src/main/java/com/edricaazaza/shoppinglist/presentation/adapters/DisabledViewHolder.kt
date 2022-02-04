package com.edricaazaza.shoppinglist.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.edricaazaza.shoppinglist.databinding.ItemShopDisabledBinding
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem

class DisabledViewHolder(
    private val binding: ItemShopDisabledBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ShopItem){
        binding.title.text = item.name
        binding.count.text = item.count.toString()
    }


}