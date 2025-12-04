package com.id.makanku.DetailToko

data class MenuModel(
    val nama: String,
    val deskripsi: String,
    val harga: String,
    val imageRes: Int,
    val diskon: String? = null
)