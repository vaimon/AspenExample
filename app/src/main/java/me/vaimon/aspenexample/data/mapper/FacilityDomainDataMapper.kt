package me.vaimon.aspenexample.data.mapper

import me.vaimon.aspenexample.data.models.FacilityData
import me.vaimon.aspenexample.domain.entities.FacilityEntity
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class FacilityDomainDataMapper @Inject constructor(): Mapper<FacilityEntity, FacilityData> {
    override fun from(e: FacilityData): FacilityEntity {
        return FacilityEntity(
            e.title,
            e.iconId
        )
    }

    override fun to(t: FacilityEntity): FacilityData {
        return FacilityData(
            t.title,
            t.iconId
        )
    }
}