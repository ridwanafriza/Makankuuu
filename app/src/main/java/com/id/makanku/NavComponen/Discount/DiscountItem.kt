package com.id.makanku.NavComponen.Discount

data class DiscountItem(
    val id: Int,
    val name: String,
    val desc: String,
    val price: String,
    val discountPercent: Int,
    val imageRes: Int
)