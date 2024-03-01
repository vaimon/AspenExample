package me.vaimon.aspenexample.ui.mapper

import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.ui.models.Tour
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class TourAppDomainMapper @Inject constructor(): Mapper<Tour, TourEntity> {
    override fun from(e: TourEntity): Tour {
        return Tour(
            title = e.title,
            imageUri = e.imageUri,
            nightsCount = e.nightsCount,
            daysCount = e.daysCount,
        )
    }

    override fun to(t: Tour): TourEntity {
        return TourEntity(
            title = t.title,
            imageUri = t.imageUri,
            nightsCount = t.nightsCount,
            daysCount = t.daysCount,
        )
    }
}