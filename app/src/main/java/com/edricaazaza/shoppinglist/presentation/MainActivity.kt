package com.edricaazaza.shoppinglist.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.edricaazaza.shoppinglist.R
import com.edricaazaza.shoppinglist.TAG
import com.edricaazaza.shoppinglist.databinding.ActivityMainBinding
import com.edricaazaza.shoppinglist.domain.pojo.ShopItem
import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType
import com.edricaazaza.shoppinglist.presentation.adapters.AdapterListItemType.Companion.MAX_POOL_SIZE
import com.edricaazaza.shoppinglist.presentation.adapters.ShopListAdapter
import com.edricaazaza.shoppinglist.presentation.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    private val shopListAdapter = ShopListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding.mainRecycler) {
            adapter = shopListAdapter
            recycledViewPool.setMaxRecycledViews(
                AdapterListItemType.ITEM_TYPE_ENABLED,
                MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                AdapterListItemType.ITEM_TYPE_DISABLED,
                MAX_POOL_SIZE
            )
        }


        viewModel.shopList.observe(this, Observer {
            shopListAdapter.shopItemsList = it
        })

        setupListeners()
        setupOnSwipeCallback()


    }

    private fun setupOnSwipeCallback() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.removeShopItem(shopListAdapter.shopItemsList[viewHolder.adapterPosition])
                shopListAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }

        }

        ItemTouchHelper(callback).attachToRecyclerView(binding.mainRecycler)
    }

    private fun setupListeners() {
        shopListAdapter.clickListener = {
            Toast.makeText(
                applicationContext,
                getString(R.string.main_on_click_prompt),
                Toast.LENGTH_SHORT
            ).show()
        }

        shopListAdapter.longClickListener = { item ->
            viewModel.changeEnableState(item)
            shopListAdapter.notifyItemChanged(shopListAdapter.shopItemsList.indexOf(item))
        }

        binding.addItemButton.setOnClickListener {
            startActivity(Intent(this, AddShopItemActivity::class.java))
        }
    }
}