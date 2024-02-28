package me.vaimon.aspenexample.data

import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.models.Tour

object SampleData {
    val hotels = listOf(
        Hotel(
            id = 1,
            name = "Alley Palace",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Vivamus pulvinar mauris tempor elit bibendum, nec tincidunt magna tempus.",
            image = R.drawable.hotel1,
            rating = 4.1,
            reviewCount = 1298,
            price = 169,
            facilities = listOf()
        ),
        Hotel(
            id = 2,
            name = "Coeurdes Alpes",
            description = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Vivamus pulvinar mauris tempor elit bibendum, nec tincidunt magna tempus.",
            image = R.drawable.hotel2,
            rating = 4.5,
            reviewCount = 366,
            price = 199,
            facilities = listOf()
        ),
        Hotel(
            id = 3,
            name = "Aspen Hotel & Spa All Inclusive",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. ",
            image = R.drawable.hotel3,
            rating = 4.9,
            reviewCount = 10442,
            price = 279,
            facilities = listOf()
        )
    )

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
        )
    )
}