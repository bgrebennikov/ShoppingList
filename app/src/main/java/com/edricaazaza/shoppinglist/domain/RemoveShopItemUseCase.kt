package com.edricaazaza.shoppinglist.domain

import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.domain.repository.ShopListRepository

class RemoveShopItemUseCase(
    private val repository: ShopListRepository
) {

    fun removeShopItem(item : ShopItem){
        repository.removeShopItem(item)
    }

}