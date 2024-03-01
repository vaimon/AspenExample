package me.vaimon.aspenexample.data.mapper

import me.vaimon.aspenexample.data.models.TourData
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class TourDomainDataMapper @Inject constructor(): Mapper<TourEntity, TourData> {
    override fun from(e: TourData): TourEntity {
        return TourEntity(
            title = e.title,
            imageUri = e.imageUri,
            nightsCount = e.nightsCount,
            daysCount = e.daysCount,
        )
    }

    override fun to(t: TourEntity): TourData {
        return TourData(
            title = t.title,
            imageUri = t.imageUri,
            nightsCount = t.nightsCount,
            daysCount = t.daysCount,
        )
    }
}