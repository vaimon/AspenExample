package me.vaimon.aspenexample.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.vaimon.aspenexample.data.datasource.SampleDataSource
import me.vaimon.aspenexample.domain.usecase.GetHotelByIdUseCase
import me.vaimon.aspenexample.domain.usecase.SetHotelFavouriteUseCase
import me.vaimon.aspenexample.ui.mapper.HotelAppDomainMapper
import me.vaimon.aspenexample.ui.models.Hotel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getHotelByIdUseCase: GetHotelByIdUseCase,
    private val setHotelFavouriteUseCase: SetHotelFavouriteUseCase,
    hotelAppDomainMapper: HotelAppDomainMapper
) : ViewModel() {
    private val hotelId = checkNotNull(savedStateHandle.get<Int>(DetailsDestination.argName))

    private val _hotelState = MutableStateFlow<Hotel>(
        hotelAppDomainMapper.from(getHotelByIdUseCase(hotelId))
    )
    val hotelState: StateFlow<Hotel> = _hotelState

    fun onBtnFavouriteClick(hotelId: Int, isFavourite: Boolean) =
        setHotelFavouriteUseCase(hotelId, isFavourite)
}