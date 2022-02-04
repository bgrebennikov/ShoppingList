package com.edricaazaza.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.edricaazaza.shoppinglist.R
import com.edricaazaza.shoppinglist.databinding.ActivityMainBinding
import com.edricaazaza.shoppinglist.presentation.adapters.ShopListAdapter
import com.edricaazaza.shoppinglist.presentation.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()
    private val adapter = ShopListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecycler.adapter = adapter

        viewModel.shopList.observe(this, Observer {
            adapter.shopItemsList = it
        })


    }
}