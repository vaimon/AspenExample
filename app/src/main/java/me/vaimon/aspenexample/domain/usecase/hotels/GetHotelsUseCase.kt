package me.vaimon.aspenexample.domain.usecase.hotels

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.repository.HotelRepository
import javax.inject.Inject

class GetHotelsUseCase @Inject constructor(
    private val hotelRepository: HotelRepository
) {
    operator fun invoke(): StateFlow<List<HotelEntity>> = hotelRepository.hotels
}