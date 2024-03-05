package me.vaimon.aspenexample.domain.usecase.location

import kotlinx.coroutines.flow.map
import me.vaimon.aspenexample.domain.repository.LocationRepository
import me.vaimon.aspenexample.utill.Resource
import javax.inject.Inject

class GetCitiesOfStateUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    operator fun invoke() = repository.citiesOfState.map {
        if (it is Resource.Success && it.data.isEmpty()) {
            Resource.Error(Exception("No cities found"))
        } else it
    }
}