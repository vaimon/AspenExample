package me.vaimon.aspenexample.ui.screens.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.vaimon.aspenexample.domain.usecase.GetHotelsUseCase
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.domain.usecase.GetToursUseCase
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.models.Tour
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getHotelsUseCase: GetHotelsUseCase,
    getToursUseCase: GetToursUseCase,
    private val hotelAppDomainMapper: Mapper<Hotel, HotelEntity>,
    private val tourAppDomainMapper: Mapper<Tour, TourEntity>,
) : ViewModel() {
    private val _hotelsState = MutableStateFlow(
        getHotelsUseCase().map {
            hotelAppDomainMapper.from(it)
        }
    )
    val hotelsState: StateFlow<List<Hotel>> = _hotelsState

    private val _toursState = MutableStateFlow(
        getToursUseCase().map {
            tourAppDomainMapper.from(it)
        }
    )
    val toursState: StateFlow<List<Tour>> = _toursState
}