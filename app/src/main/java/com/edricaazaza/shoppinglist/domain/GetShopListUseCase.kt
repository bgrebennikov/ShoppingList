package com.edricaazaza.shoppinglist.domain

import androidx.lifecycle.LiveData
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.domain.repository.ShopListRepository

class GetShopListUseCase(
    private val repository: ShopListRepository
) {

    fun getShopList() : LiveData<List<ShopItem>>{
        return repository.getShopList()
    }

}