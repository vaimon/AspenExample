package me.vaimon.aspenexample.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import me.vaimon.aspenexample.data.datasource.LocationDataSource
import me.vaimon.aspenexample.data.mapper.StateDomainDataMapper
import me.vaimon.aspenexample.data.models.StateData
import me.vaimon.aspenexample.data.models.retrofit.StateRequestBody
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.domain.repository.LocationRepository
import me.vaimon.aspenexample.utill.Mapper
import me.vaimon.aspenexample.utill.Resource
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource,
    private val stateDomainDataMapper: Mapper<StateEntity, StateData>
) : LocationRepository {
    companion object {
        private const val COUNTRY = "United States"
    }

    override fun getStates(): Flow<Resource<List<StateEntity>>> = flow {
        emit(Resource.Loading)
//        try {
            locationDataSource.getStates(StateRequestBody(COUNTRY)).data.states.map {
                stateDomainDataMapper.from(it)
            }.let {
                emit(Resource.Success(it))
            }
//        } catch (e: Exception) {
//            emit(Resource.Error(e))
//        }
    }.flowOn(Dispatchers.IO)
}