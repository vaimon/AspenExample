package me.vaimon.aspenexample.domain.entities

class HotelEntity(
    val id: Int,
    val name: String,
    val description: String,
    val imageUri: String,
    val rating: Double,
    val reviewCount: Int,
    val price: Int,
    val facilities: List<FacilityEntity>
)