package me.vaimon.aspenexample.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
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

    private val _hotels = MutableStateFlow(
        sampleDataSource.hotels.map { hotelDomainDataMapper.from(it) }
    )
    override val hotels: StateFlow<List<HotelEntity>> = _hotels

    override val tours: Flow<List<TourEntity>> = flow {
        emit(sampleDataSource.tours.map { tourDomainDataMapper.from(it) })
    }

    override fun getHotelById(id: Int): HotelEntity {
        return hotelDomainDataMapper.from(sampleDataSource.getHotelById(id))
    }

    override fun setHotelFavourite(id: Int, isFavourite: Boolean) {
        sampleDataSource.setHotelFavourite(id, isFavourite)
        _hotels.value = sampleDataSource.hotels.map { hotelDomainDataMapper.from(it) }
    }
}