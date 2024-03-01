package me.vaimon.aspenexample.ui.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun formatRating(rating: Double): String = DecimalFormat("#.#", DecimalFormatSymbols(Locale.US)).format(rating)