package me.vaimon.aspenexample.di.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.aspenexample.data.mapper.FacilityDomainDataMapper
import me.vaimon.aspenexample.data.mapper.HotelDomainDataMapper
import me.vaimon.aspenexample.data.mapper.TourDomainDataMapper
import me.vaimon.aspenexample.data.models.FacilityData
import me.vaimon.aspenexample.data.models.HotelData
import me.vaimon.aspenexample.data.models.TourData
import me.vaimon.aspenexample.domain.entities.FacilityEntity
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.utill.Mapper

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {
    @Binds
    abstract fun provideFacilityDomainDataMapper(
        mapper: FacilityDomainDataMapper
    ): Mapper<FacilityEntity, FacilityData>

    @Binds
    abstract fun provideHotelDomainDataMapper(
        mapper: HotelDomainDataMapper
    ): Mapper<HotelEntity, HotelData>

    @Binds
    abstract fun provideTourDomainDataMapper(
        mapper: TourDomainDataMapper
    ): Mapper<TourEntity, TourData>
}