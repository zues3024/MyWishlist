package com.example.mywishlist

class WishItemFetcher {
    companion object {
        val item = listOf("Pants")
        val price = "19.99"
        val storeURL = "Target.com"
        fun getWishItems(): MutableList<WishItem> {
            var wishItems: MutableList<WishItem> = ArrayList()
            for (item in item) {
                val wishItem = WishItem(item, price.toDouble(), storeURL)
                wishItems.add(wishItem)
            }
            return wishItems
        }

        fun getNext5Emails(): MutableList<WishItem> {
            var newEmails: MutableList<WishItem> = ArrayList()
            for (i in 10..14) {
                val email = WishItem(item[i], price.toDouble(), storeURL)
                newEmails.add(email)
            }
            return newEmails
        }
    }
}