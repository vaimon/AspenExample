package me.vaimon.aspenexample.ui.dialogs.choose_city

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.domain.usecase.location.GetCitiesOfStateUseCase
import me.vaimon.aspenexample.domain.usecase.location.GetCountryStatesUseCase
import me.vaimon.aspenexample.domain.usecase.location.SaveLocationUseCase
import me.vaimon.aspenexample.domain.usecase.location.SelectStateUseCase
import me.vaimon.aspenexample.ui.models.State
import me.vaimon.aspenexample.utill.Mapper
import me.vaimon.aspenexample.utill.Resource
import me.vaimon.aspenexample.utill.map
import javax.inject.Inject

@HiltViewModel
class CityChooseViewModel @Inject constructor(
    getCountryStatesUseCase: GetCountryStatesUseCase,
    getCitiesOfStateUseCase: GetCitiesOfStateUseCase,
    private val selectStateUseCase: SelectStateUseCase,
    private val saveLocationUseCase: SaveLocationUseCase,
    stateAppDomainMapper: Mapper<State, StateEntity>
) : ViewModel() {
    val states: StateFlow<Resource<List<State>>> = getCountryStatesUseCase().map {
        it.map(stateAppDomainMapper::from)
    }.stateIn(viewModelScope, SharingStarted.Lazily, Resource.Loading)

    val cities = getCitiesOfStateUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            Resource.Success(emptyList())
        )

    private val _selectedState = MutableStateFlow<State?>(null)
    val selectedState: StateFlow<State?> = _selectedState.asStateFlow()
    fun onStateSelected(state: State?) {
        _selectedState.value = state
        selectStateUseCase(state?.name)
    }

    fun onCitySelected(city: String){
        viewModelScope.launch {
            saveLocationUseCase(
                stateCode = _selectedState.value?.code,
                city = city
            )
        }
    }

}