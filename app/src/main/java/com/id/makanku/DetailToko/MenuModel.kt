package com.id.makanku.DetailToko

import android.R

data class MenuModel(
    val nama: String,
    val deskripsi: String,
    val harga: Int,
    val imageRes: Int,
    val discount: String? = null
)

