package com.edricaazaza.shoppinglist.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edricaazaza.shoppinglist.databinding.ItemShopDisabledBinding
import com.edricaazaza.shoppinglist.databinding.ItemShopEnabledBinding
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType.Companion.ITEM_TYPE_DISABLED
import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType.Companion.ITEM_TYPE_ENABLED
import java.lang.IllegalArgumentException

class ShopListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var count = 0

    var shopItemsList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        Log.i("MESSAGE", "ViewHolder's created: ${count++}")

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
        when(holder){
            is EnabledViewHolder -> holder.bind(shopItemsList[position])
            is DisabledViewHolder -> holder.bind(shopItemsList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return shopItemsList[position].getType()
    }

    override fun getItemCount(): Int = shopItemsList.size
}