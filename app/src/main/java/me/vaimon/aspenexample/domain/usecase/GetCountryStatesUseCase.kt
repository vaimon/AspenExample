package me.vaimon.aspenexample.domain.usecase

import kotlinx.coroutines.flow.Flow
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.domain.repository.LocationRepository
import me.vaimon.aspenexample.utill.Resource
import javax.inject.Inject

class GetCountryStatesUseCase @Inject constructor(
    private val locationRepository: LocationRepository
){
    operator fun invoke(): Flow<Resource<List<StateEntity>>> = locationRepository.getStates()
}