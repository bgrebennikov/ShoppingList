package com.edricaazaza.shoppinglist.domain

import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.domain.repository.ShopListRepository

class AddShopItemUseCase(
    private val repository: ShopListRepository
) {

    fun addShopItem(item : ShopItem){
        repository.addShopItem(item)
    }

}