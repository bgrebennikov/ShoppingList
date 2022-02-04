package com.edricaazaza.shoppinglist.domain.pojo

data class ShopItem(
    var id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)
