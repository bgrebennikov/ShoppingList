package com.edricaazaza.shoppinglist.presentation.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edricaazaza.shoppinglist.TAG
import com.edricaazaza.shoppinglist.data.ShopListRepositoryImpl
import com.edricaazaza.shoppinglist.domain.EditShopItemUseCase
import com.edricaazaza.shoppinglist.domain.GetShopListUseCase
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

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