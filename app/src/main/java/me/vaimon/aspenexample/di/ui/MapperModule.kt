package me.vaimon.aspenexample.di.ui

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.aspenexample.data.mapper.FacilityDomainDataMapper
import me.vaimon.aspenexample.data.mapper.HotelDomainDataMapper
import me.vaimon.aspenexample.data.models.FacilityData
import me.vaimon.aspenexample.data.models.HotelData
import me.vaimon.aspenexample.domain.entities.FacilityEntity
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.ui.mapper.FacilityAppDomainMapper
import me.vaimon.aspenexample.ui.mapper.HotelAppDomainMapper
import me.vaimon.aspenexample.ui.mapper.TourAppDomainMapper
import me.vaimon.aspenexample.ui.models.Facility
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.models.Tour
import me.vaimon.aspenexample.utill.Mapper

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {
    @Binds
    abstract fun provideFacilityAppDomainMapper(
        mapper: FacilityAppDomainMapper
    ): Mapper<Facility, FacilityEntity>

    @Binds
    abstract fun provideHotelAppDomainMapper(
        mapper: HotelAppDomainMapper
    ): Mapper<Hotel, HotelEntity>

    @Binds
    abstract fun provideTourAppDomainMapper(
        mapper: TourAppDomainMapper
    ): Mapper<Tour, TourEntity>
}