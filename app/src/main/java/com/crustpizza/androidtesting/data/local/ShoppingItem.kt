package com.crustpizza.androidtesting.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("shopping_items")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String
)