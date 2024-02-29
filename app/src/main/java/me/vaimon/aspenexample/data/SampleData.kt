package me.vaimon.aspenexample.data

import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.models.Facility
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.models.Tour

object SampleData {

    val availableFacilities: List<Facility> = listOf(
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
            image = R.drawable.hotel1,
            rating = 4.1,
            reviewCount = 1298,
            price = 169,
            facilities = availableFacilities.drop(2)
        ),
        Hotel(
            id = 2,
            name = "Coeurdes Alpes",
            description = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Vivamus pulvinar mauris tempor elit bibendum, nec tincidunt magna tempus.",
            image = R.drawable.hotel2,
            rating = 4.5,
            reviewCount = 366,
            price = 199,
            facilities = availableFacilities
        ),
        Hotel(
            id = 3,
            name = "Aspen Hotel & Spa All Inclusive",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. ",
            image = R.drawable.hotel3,
            rating = 4.9,
            reviewCount = 10442,
            price = 279,
            facilities = availableFacilities.take(2)
        )
    )

    fun getHotelById(id: Int): Hotel = hotels[id - 1]

    val tours = listOf(
        Tour(
            "Explore Aspen",
            R.drawable.rechotel1,
            4,
            5
        ),
        Tour(
            "Luxurious Aspen",
            R.drawable.rechotel2,
            2,
            3
        ),
        Tour(
            "Lucky Aspen",
            R.drawable.hotel1,
            11,
            12
        ),
        Tour(
            "Night Aspen",
            R.drawable.hotel2,
            7,
            8
        )
    )
}