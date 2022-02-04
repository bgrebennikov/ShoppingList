package com.edricaazaza.shoppinglist.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edricaazaza.shoppinglist.data.ShopListRepositoryImpl
import com.edricaazaza.shoppinglist.domain.EditShopItemUseCase
import com.edricaazaza.shoppinglist.domain.GetShopListUseCase
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun editShopItem(item : ShopItem){
        repository.editShopItem(item)
    }

    fun removeShopItem(item : ShopItem){
        repository.removeShopItem(item)
    }

    fun changeEnableState(item : ShopItem){
        repository.changeEnableState(item)
    }

}