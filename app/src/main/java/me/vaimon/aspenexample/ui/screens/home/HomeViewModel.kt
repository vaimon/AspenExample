package me.vaimon.aspenexample.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import me.vaimon.aspenexample.domain.usecase.hotels.GetHotelsUseCase
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.domain.usecase.tours.GetToursUseCase
import me.vaimon.aspenexample.domain.usecase.hotels.SetHotelFavouriteUseCase
import me.vaimon.aspenexample.domain.usecase.location.GetCurrentLocationUseCase
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.models.Tour
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getHotelsUseCase: GetHotelsUseCase,
    getToursUseCase: GetToursUseCase,
    getCurrentLocationUseCase: GetCurrentLocationUseCase,
    private val setHotelFavouriteUseCase: SetHotelFavouriteUseCase,
    private val hotelAppDomainMapper: Mapper<Hotel, HotelEntity>,
    private val tourAppDomainMapper: Mapper<Tour, TourEntity>,
) : ViewModel() {



    @OptIn(ExperimentalCoroutinesApi::class)
    val hotelsState = getHotelsUseCase().mapLatest {
        it.map{
            hotelAppDomainMapper.from(it)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, listOf())

    val toursState = getToursUseCase().map{
        it.map{ tourAppDomainMapper.from(it)}
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), listOf())

    val currentLocation = getCurrentLocationUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    fun onHotelFavoured(hotelId: Int, isFavourite: Boolean){
        setHotelFavouriteUseCase(hotelId, isFavourite)
    }
}