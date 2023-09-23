package com.example.mywishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var wishItems: List<WishItem>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishListRV = findViewById<RecyclerView>(R.id.wishlist_RV)
        val inputItem = findViewById<EditText>(R.id.itemInputView)
        val inputPrice = findViewById<EditText>(R.id.priceInputView)
        val inputURL = findViewById<EditText>(R.id.storeInputView)

        wishItems = WishItemFetcher.getWishItems()
        val wishListAdapter = WishListAdapter(wishItems)
        wishListRV.adapter = wishListAdapter
        wishListRV.layoutManager = LinearLayoutManager(this)
        findViewById<Button>(R.id.submitButton).setOnClickListener{
            val newWishItem = WishItemFetcher.getNext5Emails()
            (wishItems as MutableList<WishItem>).addAll(newWishItem)
            wishListAdapter.notifyDataSetChanged()
        }
    }
}