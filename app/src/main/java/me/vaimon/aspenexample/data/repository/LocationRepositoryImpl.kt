package me.vaimon.aspenexample.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import me.vaimon.aspenexample.data.datasource.DataStoreDataSource
import me.vaimon.aspenexample.data.datasource.LocationDataSource
import me.vaimon.aspenexample.data.models.StateData
import me.vaimon.aspenexample.data.models.retrofit.CitiesRequestBody
import me.vaimon.aspenexample.data.models.retrofit.StatesRequestBody
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.domain.repository.LocationRepository
import me.vaimon.aspenexample.utill.Mapper
import me.vaimon.aspenexample.utill.Resource
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource,
    private val dataStoreDataSource: DataStoreDataSource,
    private val stateDomainDataMapper: Mapper<StateEntity, StateData>
) : LocationRepository {
    companion object {
        private const val COUNTRY = "United States"
    }

    override val states: Flow<Resource<List<StateEntity>>> = flow {
        emit(Resource.Loading)
        try {
            locationDataSource.getStates(StatesRequestBody(COUNTRY)).data.states.map {
                stateDomainDataMapper.from(it)
            }.let {
                emit(Resource.Success(it))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }.flowOn(Dispatchers.IO)

    private val selectedState = MutableStateFlow<String?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    override val citiesOfState: Flow<Resource<List<String>>> = selectedState.flatMapLatest { state ->
        flow{
            if (state == null) {
                emit(Resource.Success(emptyList()))
                return@flow
            }
            emit(Resource.Loading)
            try {
                locationDataSource.getCitiesOfState(
                    CitiesRequestBody(COUNTRY, state)
                ).data.let {
                    emit(Resource.Success(it))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e))
            }
        }
    }.flowOn(Dispatchers.IO)

    override val currentLocation: Flow<String?> = dataStoreDataSource.location

    override suspend fun saveLocation(location: String) {
        dataStoreDataSource.saveLocation(location)
    }

    override fun setState(state: String?) {
        selectedState.value = state
    }
}