package com.edricaazaza.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.domain.repository.ShopListRepository
import java.lang.RuntimeException
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private var autoIncrementId = 0

    init {
        for (i in 0..100){
            addShopItem(
                ShopItem(
                    name = "item: $i",
                    count = i,
                    enabled = true
                )
            )
        }
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData
    }

    override fun getShopItemById(itemId: Int): ShopItem {
        return shopList.find { it.id == itemId } ?: throw RuntimeException(
            "Element with id $itemId not found"
        )
    }

    override fun addShopItem(item: ShopItem) {
        if(item.id == ShopItem.UNDEFINED_ID) item.id = autoIncrementId++
        shopList.add(item)
        updateLiveData()
    }

    override fun removeShopItem(item: ShopItem) {
        shopList.remove(item)
        updateLiveData()
    }

    override fun editShopItem(item: ShopItem) {
        shopList.remove(shopList.find { it.id == item.id })
        addShopItem(item)
    }

    override fun changeEnableState(item: ShopItem) {
        shopList.find { it.id == item.id }.apply {
            this!!.enabled = !this.enabled
        }
        updateLiveData()
    }

    private fun updateLiveData(){
        shopListLiveData.value = shopList.toList()
    }

}