package com.id.makanku

data class MenuModel(
    val nama: String,
    val deskripsi: String,
    val harga: String,
    val imageRes: Int,
    val diskon: String? = null
)