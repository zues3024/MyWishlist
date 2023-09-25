package com.example.mywishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val wishListItems = mutableListOf<WishItem>()
    private lateinit var adapter: WishListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.wishlist_RV)
        adapter = WishListAdapter(wishListItems)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val item = findViewById<EditText>(R.id.itemInputView)
        val price = findViewById<EditText>(R.id.priceInputView)
        val storeURL = findViewById<EditText>(R.id.storeInputView)
        findViewById<Button>(R.id.submitButton).setOnClickListener {
            val newItem = item.text.toString()
            val newPrice = price.text.toString().toDoubleOrNull() ?: 0.00
            val newStoreURL = storeURL.text.toString()
            val newWish = WishItem(newItem, newPrice, newStoreURL)

            wishListItems.add(newWish)
            item.text.clear()
            price.text.clear()
            storeURL.text.clear()
            adapter.notifyItemInserted(wishListItems.size)

        }

    }
}