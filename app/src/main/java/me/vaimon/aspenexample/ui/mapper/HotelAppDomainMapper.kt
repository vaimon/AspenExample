package me.vaimon.aspenexample.ui.mapper

import me.vaimon.aspenexample.domain.entities.FacilityEntity
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.ui.models.Facility
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class HotelAppDomainMapper @Inject constructor(
    private val facilityMapper: Mapper<Facility, FacilityEntity>
): Mapper<Hotel, HotelEntity> {
    override fun from(e: HotelEntity): Hotel {
        return Hotel(
            e.id,
            e.name,
            e.description,
            e.imageUri,
            e.rating,
            e.reviewCount,
            e.price,
            e.facilities.map { facilityMapper.from(it) },
            e.isFavourite
        )
    }

    override fun to(t: Hotel): HotelEntity {
        return HotelEntity(
            t.id,
            t.name,
            t.description,
            t.imageUri,
            t.rating,
            t.reviewCount,
            t.price,
            t.facilities.map { facilityMapper.to(it) },
            t.isFavourite
        )
    }
}