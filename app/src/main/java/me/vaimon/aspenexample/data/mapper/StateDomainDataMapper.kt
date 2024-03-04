package me.vaimon.aspenexample.data.mapper

import me.vaimon.aspenexample.data.models.StateData
import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class StateDomainDataMapper @Inject constructor(): Mapper<StateEntity, StateData> {
    override fun from(e: StateData): StateEntity {
        return StateEntity(
            name = e.name,
            stateCode = e.stateCode
        )
    }

    override fun to(t: StateEntity): StateData {
        return StateData(
            name = t.name,
            stateCode = t.stateCode
        )
    }
}