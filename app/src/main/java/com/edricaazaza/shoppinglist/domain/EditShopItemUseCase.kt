package com.edricaazaza.shoppinglist.domain

import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.domain.repository.ShopListRepository

class EditShopItemUseCase(
    private val repository: ShopListRepository
) {

    fun editShopItem(item: ShopItem){
        repository.editShopItem(item)
    }

}