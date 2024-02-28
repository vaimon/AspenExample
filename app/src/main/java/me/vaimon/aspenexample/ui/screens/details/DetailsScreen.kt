package me.vaimon.aspenexample.ui.screens.details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.data.SampleData

import me.vaimon.aspenexample.navigation.NavigationDestinationWithArg
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.screens.home.HomeBody
import me.vaimon.aspenexample.ui.screens.home.components.TitleWithAction
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.util.PreviewMediumScreen

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
    DetailsBody(
        hotel = hotel
    )
}

@Composable
fun DetailsBody(
    hotel: Hotel
) {
    Text(
        text = hotel.name,
        style = MaterialTheme.typography.headlineMedium,
        fontSize = 24.sp
    )
}

@PreviewMediumScreen
@Composable
fun PreviewDetails(){
    AspenExampleTheme {
        DetailsBody(hotel = SampleData.getHotelById(1))
    }
}