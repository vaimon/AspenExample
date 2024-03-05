package me.vaimon.aspenexample.domain.usecase.location

import me.vaimon.aspenexample.domain.repository.LocationRepository
import javax.inject.Inject

class SelectStateUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    operator fun invoke(state: String?) = repository.setState(state)
}