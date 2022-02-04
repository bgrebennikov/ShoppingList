package com.edricaazaza.shoppinglist.domain

import com.edricaazaza.shoppinglist.domain.repository.ShopListRepository

class RemoveShopItemUseCase(
    private val repository: ShopListRepository
) {

    fun removeShopItem(itemId : Int){
        repository.removeShopItem(itemId)
    }

}