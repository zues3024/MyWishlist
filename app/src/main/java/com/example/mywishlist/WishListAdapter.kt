package com.example.mywishlist

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
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return wishListItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishItem1= wishListItems.get(position)
        // Set item views based on views and data model
        holder.itemTextView.text = wishItem1.item
        holder.priceTextView.text = wishItem1.price.toString()
        holder.storeTextView.text = wishItem1.store
    }
}