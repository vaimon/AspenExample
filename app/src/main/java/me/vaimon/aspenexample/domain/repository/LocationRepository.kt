package me.vaimon.aspenexample.domain.repository

import kotlinx.coroutines.flow.Flow
import me.vaimon.aspenexample.data.models.retrofit.StateRequestResponse
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.utill.Resource

interface LocationRepository {
    fun getStates(): Flow<Resource<List<StateEntity>>>
}