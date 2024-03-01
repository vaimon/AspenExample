package me.vaimon.aspenexample.data.models

import androidx.annotation.DrawableRes

data class FacilityData(
    val title: String,
    @DrawableRes val iconId: Int
)