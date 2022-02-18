package com.edricaazaza.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.edricaazaza.shoppinglist.data.entity.ShopItemDbModel

@Dao
interface ShopListDao {

    @Query(
        "SELECT * from shop_items"
    )
    fun getShopList(): LiveData<List<ShopItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopItem(shopItem: ShopItemDbModel)

    @Query(
        "DELETE FROM shop_items WHERE id=:itemId"
    )
    fun removeShopItem(itemId: Int)

    @Query(
        "SELECT * FROM shop_items WHERE id=:itemId LIMIT 1"
    )
    fun getShopItemById(itemId: Int): ShopItemDbModel




}