package me.vaimon.aspenexample.domain.usecase.location

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.vaimon.aspenexample.domain.repository.LocationRepository
import javax.inject.Inject

class GetCurrentLocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    operator fun invoke(): Flow<String?> = repository.currentLocation

}