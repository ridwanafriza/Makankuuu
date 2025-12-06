package com.id.makanku.SearchRestorant

data class RestaurantModel(
    val nama: String,
    val rating: String,
    val info: String,
    val imageRes: Int,
    val diskon: String? = null
)