package me.vaimon.aspenexample.data.repository

import me.vaimon.aspenexample.data.datasource.SampleDataSource
import me.vaimon.aspenexample.data.models.HotelData
import me.vaimon.aspenexample.data.models.TourData
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.domain.repository.HotelRepository
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val sampleDataSource: SampleDataSource,
    private val hotelDomainDataMapper: Mapper<HotelEntity, HotelData>,
    private val tourDomainDataMapper: Mapper<TourEntity, TourData>
): HotelRepository{
    override fun getHotels(): List<HotelEntity> {
        return sampleDataSource.hotels.map { hotelDomainDataMapper.from(it) }
    }

    override fun getTours(): List<TourEntity> {
        return sampleDataSource.tours.map { tourDomainDataMapper.from(it) }
    }

    override fun getHotelById(id: Int): HotelEntity {
        return hotelDomainDataMapper.from(sampleDataSource.getHotelById(id))
    }
}