package com.edricaazaza.shoppinglist.domain.repository

import com.edricaazaza.shoppinglist.domain.pojo.ShopItem

interface ShopListRepository {

    fun getShopList() : List<ShopItem>

    fun getShopItemById(itemId: Int) : ShopItem

    fun addShopItem(item : ShopItem)

    fun removeShopItem(itemId : Int)

    fun editShopItem(item: ShopItem)

}