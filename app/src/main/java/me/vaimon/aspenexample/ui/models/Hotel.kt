package me.vaimon.aspenexample.ui.models

import androidx.annotation.DrawableRes

data class Hotel(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val rating: Double,
    val reviewCount: Int,
    val price: Int,
    val facilities: List<Facility>
)