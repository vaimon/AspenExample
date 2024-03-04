package me.vaimon.aspenexample.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.aspenexample.data.datasource.LocationDataSource
import me.vaimon.aspenexample.data.datasource.SampleDataSource
import me.vaimon.aspenexample.data.models.HotelData
import me.vaimon.aspenexample.data.models.StateData
import me.vaimon.aspenexample.data.models.TourData
import me.vaimon.aspenexample.data.repository.HotelRepositoryImpl
import me.vaimon.aspenexample.data.repository.LocationRepositoryImpl
import me.vaimon.aspenexample.domain.entities.HotelEntity
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.domain.entities.TourEntity
import me.vaimon.aspenexample.domain.repository.HotelRepository
import me.vaimon.aspenexample.domain.repository.LocationRepository
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideHotelRepository(
        sampleDataSource: SampleDataSource,
        hotelMapper: Mapper<HotelEntity, HotelData>,
        tourMapper: Mapper<TourEntity, TourData>,
    ): HotelRepository {
        return HotelRepositoryImpl(
            sampleDataSource,
            hotelMapper,
            tourMapper
        )
    }

    @Provides
    @Singleton
    fun provideLocationRepository(
        locationDataSource: LocationDataSource,
        stateDomainDataMapper: Mapper<StateEntity, StateData>
    ): LocationRepository {
        return LocationRepositoryImpl(
            locationDataSource,
            stateDomainDataMapper
        )
    }
}