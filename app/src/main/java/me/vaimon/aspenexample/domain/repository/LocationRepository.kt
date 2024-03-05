package me.vaimon.aspenexample.domain.repository

import kotlinx.coroutines.flow.Flow
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.utill.Resource

interface LocationRepository {
    val states: Flow<Resource<List<StateEntity>>>

    val citiesOfState: Flow<Resource<List<String>>>
    fun setState(state: String?)
}