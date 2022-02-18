package com.edricaazaza.shoppinglist.presentation.viewModels

import android.app.Application
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edricaazaza.shoppinglist.data.ShopListRepositoryImpl
import com.edricaazaza.shoppinglist.domain.AddShopItemUseCase
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import kotlinx.coroutines.delay

class AddShopItemViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)
    private val addShopItemUseCase = AddShopItemUseCase(repository)

    private val nameInputError = MutableLiveData<Unit>()
    private val countInputError = MutableLiveData<Unit>()

    private val inputName = MutableLiveData<String>()
    private val inputCount = MutableLiveData<String>()

    fun addItem(name: String?, count: String?) {

        if (!validateName(name) || !validateCount(count)) return

        addShopItemUseCase.addShopItem(
            ShopItem(
                name!!,
                count!!.toInt(),
                enabled = true
            )
        )

    }

    fun userInputName(name: String?) {
        inputName.value = name
    }

    fun userInputCount(count: String?) {
        inputCount.value = count
    }

    private fun validateName(name: String?): Boolean {
        if (name.isNullOrEmpty()) {
            nameInputError.value = Unit
            return false
        }
        return true
    }

    private fun validateCount(count: String?): Boolean {
        if (count.isNullOrEmpty()) {
            countInputError.value = Unit
            return false
        }
        if (!count.isDigitsOnly() && count.toInt() < 1) {
            countInputError.value = Unit
            return false
        }

        return true
    }

}