package com.edricaazaza.shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem

interface ShopListRepository {

    fun getShopList() : LiveData<List<ShopItem>>

    fun getShopItemById(itemId: Int) : ShopItem

    fun addShopItem(item : ShopItem)

    fun removeShopItem(item : ShopItem)

    fun editShopItem(item: ShopItem)

    fun changeEnableState(item: ShopItem)

}