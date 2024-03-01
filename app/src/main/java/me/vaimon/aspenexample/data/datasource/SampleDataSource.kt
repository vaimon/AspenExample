package me.vaimon.aspenexample.data.datasource

import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.data.models.FacilityData
import me.vaimon.aspenexample.data.models.HotelData
import me.vaimon.aspenexample.data.models.TourData
import me.vaimon.aspenexample.ui.models.Hotel
import javax.inject.Inject

class SampleDataSource @Inject constructor() {

    private val availableFacilities: List<FacilityData> = listOf(
        FacilityData(
            "1 Heater", R.drawable.icon_facility_wifi
        ),
        FacilityData(
            "Dinner", R.drawable.icon_facility_utensils
        ),
        FacilityData(
            "1 Tub", R.drawable.icon_facility_tub
        ),
        FacilityData(
            "Pool", R.drawable.icon_facility_pool
        ),
        FacilityData(
            "Wifi", R.drawable.icon_facility_wifi
        ),
    )

    val hotels = listOf(
        HotelData(
            id = 1,
            name = "Alley Palace",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Vivamus pulvinar mauris tempor elit bibendum, nec tincidunt magna tempus.",
            imageUri = "file:///android_asset/hotel1.png",
            rating = 4.1,
            reviewCount = 1298,
            price = 169,
            facilities = availableFacilities.drop(2)
        ),
        HotelData(
            id = 2,
            name = "Coeurdes Alpes",
            description = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and rutrum lobortis tortor. Aliquam mollis felis tincidunt consequat pellentesque. Vivamus pulvinar mauris tempor elit bibendum, nec tincidunt magna tempus.",
            imageUri = "file:///android_asset/hotel2.png",
            rating = 4.5,
            reviewCount = 366,
            price = 199,
            facilities = availableFacilities
        ),
        HotelData(
            id = 3,
            name = "Aspen Hotel & Spa All Inclusive",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In rutrum lobortis tortor. ",
            imageUri = "file:///android_asset/hotel3.png",
            rating = 4.9,
            reviewCount = 10442,
            price = 279,
            facilities = availableFacilities.take(2)
        )
    )

    fun getHotelById(id: Int): HotelData = hotels[id - 1]

    val tours = listOf(
        TourData(
            "Explore Aspen",
            "file:///android_asset/rechotel1.png",
            4,
            5
        ),
        TourData(
            "Luxurious Aspen",
            "file:///android_asset/rechotel1.png",
            2,
            3
        ),
        TourData(
            "Lucky Aspen",
            "file:///android_asset/hotel1.png",
            11,
            12
        ),
        TourData(
            "Night Aspen",
            "file:///android_asset/hotel2.png",
            7,
            8
        )
    )
}