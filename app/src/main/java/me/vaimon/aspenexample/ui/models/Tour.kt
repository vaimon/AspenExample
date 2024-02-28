package me.vaimon.aspenexample.ui.models

import androidx.annotation.DrawableRes

data class Tour(
    val title: String,
    @DrawableRes val image: Int,
    val nightsCount: Int,
    val daysCount: Int
)
