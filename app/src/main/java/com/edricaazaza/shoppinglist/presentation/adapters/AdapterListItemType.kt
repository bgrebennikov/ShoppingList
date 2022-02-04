package com.edricaazaza.shoppinglist.presentation.adapters

interface AdapterListItemType {

    fun getType() : Int

    companion object{
        const val ITEM_TYPE_DISABLED = 0
        const val ITEM_TYPE_ENABLED = 1
    }
}