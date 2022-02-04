package com.edricaazaza.shoppinglist.domain

import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.domain.repository.ShopListRepository

class GetShopItemByIdUseCase(
    private val repository: ShopListRepository
) {

    fun getShopItemById(itemId: Int): ShopItem {
        return repository.getShopItemById(itemId)
    }

}