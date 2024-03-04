package me.vaimon.aspenexample.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.common.CompositeHeader
import me.vaimon.aspenexample.ui.common.TitleWithAction
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.models.Tour
import me.vaimon.aspenexample.ui.navigation.NavigationDestination
import me.vaimon.aspenexample.ui.screens.home.components.CategoryRow
import me.vaimon.aspenexample.ui.screens.home.components.CurrentLocationLabel
import me.vaimon.aspenexample.ui.screens.home.components.LargeHotelCard
import me.vaimon.aspenexample.ui.screens.home.components.SearchField
import me.vaimon.aspenexample.ui.screens.home.components.SmallTourCard
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.ui.theme.ColourfulGray
import me.vaimon.aspenexample.ui.theme.SoftBlue
import me.vaimon.aspenexample.ui.theme.labelSmallChipVariant
import me.vaimon.aspenexample.ui.util.PreviewMediumScreen
import me.vaimon.aspenexample.ui.util.SampleData

object HomeDestination : NavigationDestination {
    override val route = "home"
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigateToDetails: (Int) -> Unit,
    showCityChooseBottomSheet: () -> Unit
) {
    val hotels by viewModel.hotelsState.collectAsState()
    val tours by viewModel.toursState.collectAsState()

    val scrollState = rememberScrollState()
    Scaffold {
        HomeBody(
            hotels,
            tours,
            navigateToDetails,
            onItemFavoured = { isFavourite, hotelId ->
                viewModel.onHotelFavoured(hotelId, isFavourite)
            },
            showCityChooseBottomSheet = showCityChooseBottomSheet,
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
                .fillMaxWidth()
        )
    }
}

@Composable
fun HomeBody(
    hotels: List<Hotel>,
    tours: List<Tour>,
    navigateToDetails: (Int) -> Unit,
    showCityChooseBottomSheet: () -> Unit,
    onItemFavoured: (Boolean, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(vertical = 40.dp)) {
        val padding = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()

        Row(
            modifier = padding,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CompositeHeader(
                headerText = stringResource(R.string.aspen),
                secondaryHeaderText = stringResource(R.string.explore),
                headerSize = 32.sp,
                secondaryHeaderSize = 14.sp
            )
            CurrentLocationLabel(
                onClick = {
                    showCityChooseBottomSheet()
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        SearchField(modifier = padding)

        Spacer(modifier = Modifier.height(32.dp))
        CategoryRow(
            listOf("Location", "Hotels", "Food", "Adventure", "Accommodation")
        )

        Spacer(modifier = Modifier.height(32.dp))
        TitleWithAction(
            titleText = stringResource(R.string.title_popular),
            actionText = stringResource(R.string.label_see_all),
            action = {},
            modifier = padding
        )

        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(
                hotels,
                key = { it.id }
            ) {
                LargeHotelCard(
                    it,
                    onBtnFavouriteClick = { isFavourite ->
                        onItemFavoured(isFavourite, it.id)
                    },
                    modifier = Modifier
                        .height(240.dp)
                        .clickable {
                            navigateToDetails(it.id)
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        TitleWithAction(
            titleText = stringResource(R.string.title_recommended),
            modifier = padding
        )

        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(tours) {
                SmallTourCard(
                    it,
                    modifier = Modifier.width(166.dp)
                )
            }
        }
    }
}

@Composable
fun HotDealLabel() {
    Row(
        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_stonks),
            tint = SoftBlue,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stringResource(R.string.label_hot_deal),
            style = MaterialTheme.typography.labelSmall,
            fontSize = 10.sp
        )
    }
}

@Composable
fun TourLengthLabel(
    days: Int,
    nights: Int,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(16.dp)
    Text(
        text = "${nights}N/${days}D",
        style = MaterialTheme.typography.labelSmallChipVariant,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier
            .border(2.dp, MaterialTheme.colorScheme.onSurfaceVariant, shape)
            .clip(shape)
            .background(ColourfulGray)
            .padding(vertical = 4.dp, horizontal = 6.dp)
    )
}


@PreviewMediumScreen
@Composable
fun PreviewHome() {
    AspenExampleTheme {
        Scaffold {
            HomeBody(
                SampleData.hotels,
                SampleData.tours,
                navigateToDetails = {},
                onItemFavoured = { _, _ -> },
                showCityChooseBottomSheet = {},
                modifier = Modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
            )
        }
    }
}