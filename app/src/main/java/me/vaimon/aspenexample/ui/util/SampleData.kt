package me.vaimon.aspenexample.ui.util

import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.models.Facility
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.models.Tour

object SampleData {

    private val availableFacilities: List<Facility> = listOf(
        Facility(
            "1 Heater", R.drawable.icon_facility_wifi
        ),
        Facility(
            "Dinner", R.drawable.icon_facility_utensils
        ),
        Facility(
            "1 Tub", R.drawable.icon_facility_tub
        ),
        Facility(
            "Pool", R.drawable.icon_facility_pool
        ),
        Facility(
            "Wifi", R.drawable.icon_facility_wifi
        ),
    )

    val hotels = listOf(
        Hotel(
            id = 1,
            name = "Alley Palace",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Vivamus pulvinar mauris tempor elit bibendum, nec tincidunt magna tempus.",
            imageUri = "file:///android_asset/hotel1.png",
            rating = 4.1,
            reviewCount = 1298,
            price = 169,
            facilities = availableFacilities.drop(2),
            isFavourite = false
        ),
        Hotel(
            id = 2,
            name = "Coeurdes Alpes",
            description = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Vivamus pulvinar mauris tempor elit bibendum, nec tincidunt magna tempus.",
            imageUri = "file:///android_asset/hotel2.png",
            rating = 4.5,
            reviewCount = 366,
            price = 199,
            facilities = availableFacilities,
            isFavourite = false
        ),
        Hotel(
            id = 3,
            name = "Aspen Hotel & Spa All Inclusive",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. ",
            imageUri = "file:///android_asset/hotel3.png",
            rating = 4.9,
            reviewCount = 10442,
            price = 279,
            facilities = availableFacilities.take(2),
            isFavourite = false
        )
    )

    fun getHotelById(id: Int): Hotel = hotels[id - 1]

    val tours = listOf(
        Tour(
            "Explore Aspen",
            "file:///android_asset/rechotel1.png",
            4,
            5
        ),
        Tour(
            "Luxurious Aspen",
            "file:///android_asset/rechotel1.png",
            2,
            3
        ),
    )
}