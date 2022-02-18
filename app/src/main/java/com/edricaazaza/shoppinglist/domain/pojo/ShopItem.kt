package com.edricaazaza.shoppinglist.domain.pojo

import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType
import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType.Companion.ITEM_TYPE_DISABLED
import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType.Companion.ITEM_TYPE_ENABLED

data class ShopItem(
    val name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
) : AdapterListItemType {
    companion object {
        const val UNDEFINED_ID = 0
    }

    override fun getType(): Int {
        return if (this.enabled) ITEM_TYPE_ENABLED else ITEM_TYPE_DISABLED
    }
}
