package me.vaimon.aspenexample.domain.usecase

import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.domain.repository.HotelRepository
import javax.inject.Inject

class GetToursUseCase @Inject constructor(
    private val hotelRepository: HotelRepository
) {
    operator fun invoke(): List<TourEntity>{
        return hotelRepository.getTours()
    }
}