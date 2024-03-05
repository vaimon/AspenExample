package me.vaimon.aspenexample.domain.usecase.hotels

import me.vaimon.aspenexample.domain.repository.HotelRepository
import javax.inject.Inject

class SetHotelFavouriteUseCase @Inject constructor(
    private val hotelRepository: HotelRepository
) {
    operator fun invoke(id: Int, isFavourite: Boolean) = hotelRepository.setHotelFavourite(id, isFavourite)
}