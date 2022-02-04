package com.edricaazaza.shoppinglist.data

import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.domain.repository.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun getShopItemById(itemId: Int): ShopItem {
        return shopList.find { it.id == itemId } ?: throw RuntimeException(
            "Element with id $itemId not found"
        )
    }

    override fun addShopItem(item: ShopItem) {
        item.id = autoIncrementId++
        shopList.add(item)
    }

    override fun removeShopItem(itemId: Int) {
        shopList.removeAt(itemId)
    }

    override fun editShopItem(item: ShopItem) {
        shopList.remove(shopList.find { it.id == item.id })
        addShopItem(item)
    }

}