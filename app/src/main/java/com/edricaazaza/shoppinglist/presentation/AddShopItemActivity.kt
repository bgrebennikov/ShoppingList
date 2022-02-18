package com.edricaazaza.shoppinglist.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.edricaazaza.shoppinglist.R
import com.edricaazaza.shoppinglist.databinding.ActivityAddShopItemBinding
import com.edricaazaza.shoppinglist.presentation.viewModels.AddShopItemViewModel
import com.edricaazaza.shoppinglist.utils.CustomTextWatcher

class AddShopItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddShopItemBinding
    private val viewModel by viewModels<AddShopItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddShopItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.itemName.addTextChangedListener(object : CustomTextWatcher() {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                super.onTextChanged(p0, p1, p2, p3)
                viewModel.userInputName(p0.toString())
            }
        })

        binding.itemCount.addTextChangedListener(object : CustomTextWatcher() {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                super.onTextChanged(p0, p1, p2, p3)
                viewModel.userInputCount(p0.toString())
            }
        })

        binding.addItemButton.setOnClickListener {
            with(binding){
                Toast.makeText(applicationContext, itemName.text.toString(), Toast.LENGTH_SHORT).show()
                viewModel.addItem(itemName.text.toString(), itemCount.text.toString())
                onBackPressed()
            }
        }

    }



}