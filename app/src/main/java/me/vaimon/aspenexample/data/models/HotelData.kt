package me.vaimon.aspenexample.data.models

import androidx.annotation.DrawableRes

data class HotelData(
    val id: Int,
    val name: String,
    val description: String,
    val imageUri: String,
    val rating: Double,
    val reviewCount: Int,
    val price: Int,
    val facilities: List<FacilityData>
)