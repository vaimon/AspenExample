package me.vaimon.aspenexample.domain.usecase.tours

import kotlinx.coroutines.flow.Flow
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.domain.repository.HotelRepository
import javax.inject.Inject

class GetToursUseCase @Inject constructor(
    private val hotelRepository: HotelRepository
) {
    operator fun invoke(): Flow<List<TourEntity>> = hotelRepository.tours
}