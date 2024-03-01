package me.vaimon.aspenexample.domain.repository

import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity

interface HotelRepository {
    fun getHotels(): List<HotelEntity>

    fun getTours(): List<TourEntity>

    fun getHotelById(id: Int): HotelEntity
}