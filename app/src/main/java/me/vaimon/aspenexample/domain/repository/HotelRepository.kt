package me.vaimon.aspenexample.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity

interface HotelRepository {
    val hotels: StateFlow<List<HotelEntity>>

    val tours: Flow<List<TourEntity>>

    fun getHotelById(id: Int): HotelEntity
    fun setHotelFavourite(id: Int, isFavourite: Boolean)
}