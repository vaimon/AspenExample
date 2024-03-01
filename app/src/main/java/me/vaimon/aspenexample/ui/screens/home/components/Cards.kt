package me.vaimon.aspenexample.ui.screens.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.vaimon.aspenexample.ui.common.FavouriteButton
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.models.Tour
import me.vaimon.aspenexample.ui.screens.home.HotDealLabel
import me.vaimon.aspenexample.ui.screens.home.TourLengthLabel
import me.vaimon.aspenexample.ui.theme.labelSmallVariant

@Composable
fun LargeHotelCard(
    hotel: Hotel,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier.aspectRatio(0.77f)
    ) {
        AsyncImage(
            model = hotel.imageUri,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp))
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
        ) {
            RatingTitle(
                hotel.name,
                hotel.rating,
                Modifier.weight(1f)
            )
            FavouriteButton(
                onChecked = {},
                iconSize = 10.dp,
                modifier = Modifier
                    .padding(bottom = 16.dp, end = 16.dp)
                    .size(24.dp)
            )
        }
    }
}

@Composable
fun SmallTourCard(
    tour: Tour,
    modifier: Modifier = Modifier
) {
    Card(
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        Box{
            AsyncImage(
                model = tour.imageUri,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 4.dp, start = 4.dp, end = 4.dp, bottom = 6.dp)
                    .aspectRatio(1.72f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )
            TourLengthLabel(
                days = tour.daysCount,
                nights = tour.nightsCount,
                modifier = Modifier
                    .padding(horizontal = 9.dp)
                    .align(Alignment.BottomEnd)
            )
        }
        Text(
            text = tour.title,
            style = MaterialTheme.typography.labelSmallVariant,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        HotDealLabel()
    }
}

