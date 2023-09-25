package com.example.mywishlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter (private val wishListItems: List<WishItem>) : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // TODO: Create member variables for any view that will be set
    // as you render a row.
    val itemTextView: TextView
    val priceTextView: TextView
    val storeTextView: TextView

    // We also create a constructor that accepts the entire item row
    // and does the view lookups to find each sub-view
    init {
        // TODO: Store each of the layout's views into
        // the public final member variables created above
        itemTextView = itemView.findViewById(R.id.wishItemView)
        priceTextView = itemView.findViewById(R.id.priceView)
        storeTextView = itemView.findViewById(R.id.storeView)
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return wishListItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = wishListItems[position]
        // Set item views based on views and data model
        holder.itemTextView.text = item.item
        holder.priceTextView.text = "$${item.price}"
        holder.storeTextView.text = item.store
    }
}