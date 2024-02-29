package me.vaimon.aspenexample.ui.screens.details

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.data.SampleData
import me.vaimon.aspenexample.navigation.NavigationDestinationWithArg
import me.vaimon.aspenexample.ui.common.FavouriteButton
import me.vaimon.aspenexample.ui.common.TitleWithAction
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.screens.details.components.ExpandableText
import me.vaimon.aspenexample.ui.screens.details.components.FacilitiesRow
import me.vaimon.aspenexample.ui.screens.details.components.PriceBottomBar
import me.vaimon.aspenexample.ui.screens.details.components.ReviewsStats
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.ui.theme.Gray
import me.vaimon.aspenexample.ui.theme.Green
import me.vaimon.aspenexample.ui.theme.ShadowBlue
import me.vaimon.aspenexample.ui.theme.labelExtraBold
import me.vaimon.aspenexample.ui.theme.labelSmallVariant
import me.vaimon.aspenexample.util.PreviewMediumScreen
import me.vaimon.aspenexample.util.conditional

object DetailsDestination : NavigationDestinationWithArg<Int>() {
    override val routeBase = "details"
    override val argName = "hotelId"
}

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    navigateBack: () -> Unit
) {
    val hotel by viewModel.hotelState.collectAsState()
    val scrollableContentState = rememberScrollState()

    Scaffold(
        bottomBar = {
            val shadowAnimation by animateDpAsState(
                targetValue = if(scrollableContentState.canScrollForward) 8.dp else 0.dp,
                label = "shadowAnimation"
            )
            PriceBottomBar(
                price = hotel.price,
                onBtnBookPressed = {},
                modifier = Modifier
                    .shadow(
                        elevation = shadowAnimation,
                    )
            )
        }
    ) {
        Box {
            DetailsBody(
                hotel = hotel,
                modifier = Modifier
                    .padding(it)
                    .verticalScroll(scrollableContentState)
            )
            IconButton(
                onClick = navigateBack,
                modifier = Modifier
                    .padding(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_back),
                    tint = Gray,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun DetailsBody(
    hotel: Hotel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        FullHotelImage(
            image = hotel.image,
            onFavouriteClick = { /*TODO*/ }
        )

        Spacer(modifier = Modifier.height(14.dp))
        HotelInfo(
            hotel = hotel,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        TitleWithAction(
            titleText = "Facilities",
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        FacilitiesRow(
            hotel.facilities,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun FullHotelImage(
    @DrawableRes image: Int,
    onFavouriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(20.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        FavouriteButton(
            iconSize = 24.dp,
            modifier = Modifier
                .padding(end = 34.dp)
                .size(44.dp)
                .align(Alignment.BottomEnd)
                .shadow(
                    6.dp,
                    shape = CircleShape,
                    clip = true,
                    spotColor = ShadowBlue
                ),
            onChecked = onFavouriteClick,
        )
    }
}


@Composable
fun HotelInfo(
    hotel: Hotel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        TitleWithAction(
            titleText = hotel.name,
            titleStyle = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
            actionText = "Show map",
            actionStyle = MaterialTheme.typography.labelMedium,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(6.dp))
        ReviewsStats(
            hotel.rating,
            hotel.reviewCount
        )

        Spacer(modifier = Modifier.height(16.dp))
        ExpandableText(
            description = hotel.description
        )
    }
}


@PreviewMediumScreen
@Composable
fun PreviewDetails() {
    AspenExampleTheme {
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) {
            DetailsBody(
                hotel = SampleData.getHotelById(2)
            )
        }
    }
}