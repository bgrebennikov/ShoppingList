package com.edricaazaza.shoppinglist.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.edricaazaza.shoppinglist.databinding.ItemShopDisabledBinding
import com.edricaazaza.shoppinglist.databinding.ItemShopEnabledBinding
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType.Companion.ITEM_TYPE_DISABLED
import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType.Companion.ITEM_TYPE_ENABLED
import java.lang.IllegalArgumentException

class ShopListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var clickListener: (() -> Unit)? = null
    var longClickListener : ((ShopItem) -> Unit)? = null

    var shopItemsList = listOf<ShopItem>()
        set(value) {
            field = value
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            ITEM_TYPE_ENABLED ->
                EnabledViewHolder(
                    ItemShopEnabledBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            ITEM_TYPE_DISABLED ->
                DisabledViewHolder(
                    ItemShopDisabledBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

            else -> throw IllegalArgumentException("Invalid View type")

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = shopItemsList[position]
        when (holder) {
            is EnabledViewHolder -> holder.bind(currentItem)
            is DisabledViewHolder -> holder.bind(currentItem)
        }

        holder.itemView.setOnClickListener {
            clickListener?.invoke()
        }

        holder.itemView.setOnLongClickListener {
            longClickListener?.invoke(currentItem)
            true
        }

    }

    override fun getItemViewType(position: Int): Int {
        return shopItemsList[position].getType()
    }

    override fun getItemCount(): Int = shopItemsList.size

}