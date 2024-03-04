package me.vaimon.aspenexample.ui.dialogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.domain.usecase.GetCountryStatesUseCase
import me.vaimon.aspenexample.ui.models.State
import me.vaimon.aspenexample.utill.Mapper
import me.vaimon.aspenexample.utill.Resource
import javax.inject.Inject

@HiltViewModel
class CityChooseViewModel @Inject constructor(
    getCountryStatesUseCase: GetCountryStatesUseCase,
    stateAppDomainMapper: Mapper<State, StateEntity>
): ViewModel() {
    val states: StateFlow<Resource<List<State>>> = getCountryStatesUseCase().map{
        when(it){
            is Resource.Success -> Resource.Success(it.data.map{ stateAppDomainMapper.from(it) })
            is Resource.Error -> Resource.Error(it.exception)
            is Resource.Loading -> Resource.Loading
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, Resource.Loading)
}