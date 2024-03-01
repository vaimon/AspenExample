package me.vaimon.aspenexample.domain.usecase

import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.repository.HotelRepository
import javax.inject.Inject

class GetHotelsUseCase @Inject constructor(
    private val hotelRepository: HotelRepository
) {
    operator fun invoke(): List<HotelEntity>{
        return hotelRepository.getHotels()
    }
}