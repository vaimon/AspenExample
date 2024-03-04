package me.vaimon.aspenexample.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import me.vaimon.aspenexample.data.datasource.SampleDataSource
import me.vaimon.aspenexample.data.models.HotelData
import me.vaimon.aspenexample.data.models.TourData
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.domain.repository.HotelRepository
import me.vaimon.aspenexample.ui.util.SampleData
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
    override val hotels: StateFlow<List<HotelEntity>> = _hotels.asStateFlow()

    override val tours: Flow<List<TourEntity>> = flow {
        emit(sampleDataSource.tours.map { tourDomainDataMapper.from(it) })
    }

    override fun getHotelById(id: Int): HotelEntity {
        return hotels.value[id - 1]
    }

    override fun setHotelFavourite(id: Int, isFavourite: Boolean) {
        _hotels.update {
            val newList = it.toMutableList()
            newList[id - 1] = newList[id - 1].copy(isFavourite = isFavourite)
            newList.toList()
        }
    }
}