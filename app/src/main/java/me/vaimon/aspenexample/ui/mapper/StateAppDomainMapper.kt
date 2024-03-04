package me.vaimon.aspenexample.ui.mapper

import me.vaimon.aspenexample.domain.entities.StateEntity
import me.vaimon.aspenexample.ui.models.State
import me.vaimon.aspenexample.utill.Mapper
import javax.inject.Inject

class StateAppDomainMapper @Inject constructor(): Mapper<State, StateEntity> {
    override fun from(e: StateEntity): State {
        return State(
            e.name
        )
    }

    override fun to(t: State): StateEntity {
        throw IllegalStateException("This method should not be called.")
    }

}