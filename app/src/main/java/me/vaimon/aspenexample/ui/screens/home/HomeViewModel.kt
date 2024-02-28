package me.vaimon.aspenexample.ui.screens.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.data.SampleData
import me.vaimon.aspenexample.ui.models.Facility
import me.vaimon.aspenexample.ui.models.Hotel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _hotelsState = MutableStateFlow(SampleData.hotels)
    val hotelsState: StateFlow<List<Hotel>> = _hotelsState
}