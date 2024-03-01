package me.vaimon.aspenexample.data.mapper

import me.vaimon.aspenexample.data.models.FacilityData
import me.vaimon.aspenexample.data.models.HotelData
import me.vaimon.aspenexample.domain.entities.FacilityEntity
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class HotelDomainDataMapper
    @Inject constructor (
    private val facilityDomainDataMapper: Mapper<FacilityEntity, FacilityData>
): Mapper<HotelEntity, HotelData> {
    override fun from(e: HotelData): HotelEntity {
        return HotelEntity(
            e.id,
            e.name,
            e.description,
            e.imageUri,
            e.rating,
            e.reviewCount,
            e.price,
            e.facilities.map { facilityDomainDataMapper.from(it) },
            e.isFavourite
        )
    }

    override fun to(t: HotelEntity): HotelData {
        return HotelData(
            t.id,
            t.name,
            t.description,
            t.imageUri,
            t.rating,
            t.reviewCount,
            t.price,
            t.facilities.map { facilityDomainDataMapper.to(it) },
            t.isFavourite
        )
    }
}