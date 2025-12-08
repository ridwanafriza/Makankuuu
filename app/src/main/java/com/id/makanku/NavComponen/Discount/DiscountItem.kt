package com.id.makanku.model

data class DiscountItem(
    val name: String,
    val price: String,
    val imageRes: Int,
    val discountPercent: Int,
    val desc: String
)
