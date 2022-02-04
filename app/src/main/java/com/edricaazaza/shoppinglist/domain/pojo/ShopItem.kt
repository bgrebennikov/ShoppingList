package com.edricaazaza.shoppinglist.domain.pojo

data class ShopItem(
    val name: String,
    val count: Int,
    var enabled: Boolean,

    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
