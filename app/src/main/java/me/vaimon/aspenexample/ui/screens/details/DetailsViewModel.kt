package me.vaimon.aspenexample.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.vaimon.aspenexample.data.SampleData
import me.vaimon.aspenexample.ui.models.Hotel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val hotelId = checkNotNull(savedStateHandle.get<Int>(DetailsDestination.argName))
    val _hotelState = MutableStateFlow<Hotel>(SampleData.getHotelById(hotelId))
    val hotelState: StateFlow<Hotel> = _hotelState
}