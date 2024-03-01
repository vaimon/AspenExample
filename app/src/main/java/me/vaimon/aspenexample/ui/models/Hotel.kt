package me.vaimon.aspenexample.ui.models

import androidx.annotation.DrawableRes

data class Hotel(
    val id: Int,
    val name: String,
    val description: String,
    val imageUri: String,
    val rating: Double,
    val reviewCount: Int,
    val price: Int,
    val facilities: List<Facility>,
    val isFavourite: Boolean
)