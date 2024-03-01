package me.vaimon.aspenexample.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.aspenexample.domain.usecase.GetHotelsUseCase
import me.vaimon.aspenexample.domain.repository.HotelRepository

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideGetHotelsUseCase(
        hotelRepository: HotelRepository
    ) : GetHotelsUseCase {
        return GetHotelsUseCase(
            hotelRepository
        )
    }
}