package me.vaimon.aspenexample.ui.models

import androidx.annotation.DrawableRes

data class Facility(
    val title: String,
    @DrawableRes val icon: Int
)