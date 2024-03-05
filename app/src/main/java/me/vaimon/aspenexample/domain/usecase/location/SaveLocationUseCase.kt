package me.vaimon.aspenexample.domain.usecase.location

import me.vaimon.aspenexample.domain.repository.LocationRepository
import javax.inject.Inject

class SaveLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {
    suspend operator fun invoke(state: String, city: String){
        locationRepository.saveLocation("$city, $state")
    }
}