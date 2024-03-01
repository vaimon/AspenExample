package me.vaimon.aspenexample.domain.usecase

import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.repository.HotelRepository
import javax.inject.Inject

class GetHotelByIdUseCase @Inject constructor(
    private val hotelRepository: HotelRepository
) {
    operator fun invoke(id: Int): HotelEntity{
        return hotelRepository.getHotelById(id)
    }
}