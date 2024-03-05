package me.vaimon.aspenexample.data.models

import com.google.gson.annotations.SerializedName

data class StateData(
    val name: String,
    @SerializedName(value="state_code") val stateCode: String?
)
