package me.vaimon.aspenexample.ui.mapper

import me.vaimon.aspenexample.domain.entities.FacilityEntity
import me.vaimon.aspenexample.ui.models.Facility
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class FacilityAppDomainMapper @Inject constructor(): Mapper<Facility, FacilityEntity> {
    override fun from(e: FacilityEntity): Facility {
        return Facility(
            title = e.title,
            icon = e.iconId
        )
    }

    override fun to(t: Facility): FacilityEntity {
        return FacilityEntity(
            title = t.title,
            iconId = t.icon
        )
    }
}