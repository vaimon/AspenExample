package me.vaimon.aspenexample.ui.dialogs.choose_city

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.dialogs.choose_city.components.LocationLoader
import me.vaimon.aspenexample.ui.models.State
import me.vaimon.aspenexample.ui.navigation.NavigationDestination
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.ui.theme.DarkGray
import me.vaimon.aspenexample.ui.theme.Gray
import me.vaimon.aspenexample.ui.theme.VeryDarkGray
import me.vaimon.aspenexample.ui.util.PreviewMediumScreen
import me.vaimon.aspenexample.utill.Resource

object CityChooseDestination : NavigationDestination {
    override val route: String
        get() = "city_choose"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityChooseBottomSheet(
    viewModel: CityChooseViewModel,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    val states by viewModel.states.collectAsState()
    val selectedState by viewModel.selectedState.collectAsState()
    val cities by viewModel.cities.collectAsState()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        dragHandle = {
            BottomSheetDefaults.DragHandle(
                color = DarkGray
            )
        },
        modifier = modifier
    ) {
        ChooseCityBottomSheetBody(
            states = states,
            selectedState = selectedState,
            cities = cities,
            onStateSelected = viewModel::onStateSelected,
            onCitySelected = {
                viewModel.onCitySelected(it)
                navigateBack()
            }
        )
    }
}

@Composable
fun ChooseCityBottomSheetBody(
    states: Resource<List<State>>,
    selectedState: State?,
    cities: Resource<List<String>>,
    onStateSelected: (State?) -> Unit,
    onCitySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AnimatedVisibility(visible = selectedState != null) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_back),
                    contentDescription = null,
                    tint = VeryDarkGray,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            onStateSelected(null)
                        }
                )
            }
            Text(
                text = selectedState?.name ?: stringResource(R.string.header_state),
                style = MaterialTheme.typography.headlineMedium,
                color = VeryDarkGray,
                fontSize = 24.sp,
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(420.dp)
                .fillMaxWidth()
        ) {
            if (selectedState != null)
                LocationLoader(
                    data = cities,
                    onItemSelected = onCitySelected,
                )
            else
                LocationLoader(
                    data = states,
                    onItemSelected = onStateSelected,
                )
        }
    }
}

@PreviewMediumScreen
@Composable
fun CityChooseBottomSheetPreview() {
    AspenExampleTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            ChooseCityBottomSheetBody(
                Resource.Loading,
                null,
                Resource.Loading,
                {},
                {}
            )
        }
    }

}