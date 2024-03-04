package me.vaimon.aspenexample.ui.dialogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.models.State
import me.vaimon.aspenexample.ui.navigation.NavigationDestination
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.ui.theme.DarkGray
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
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    val states by viewModel.states.collectAsState()

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
            states = states
        )
    }
}

@Composable
fun ChooseCityBottomSheetBody(
    states: Resource<List<State>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Row {
            Text(
                stringResource(R.string.header_state),
                style = MaterialTheme.typography.headlineMedium,
                color = VeryDarkGray,
                fontSize = 24.sp
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(420.dp).fillMaxWidth()
        ) {
            when (states) {
                is Resource.Error -> {
                    Text(
                        text = states.exception.localizedMessage ?: "Unknown Error",
                        style = MaterialTheme.typography.bodyMedium,
                        color = DarkGray,
                        fontSize = 18.sp
                    )
                }

                is Resource.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                    )
                }

                is Resource.Success -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding = (PaddingValues(vertical = 16.dp))
                    ) {
                        items(states.data) {
                            Text(
                                text = it.name,
                                style = MaterialTheme.typography.bodyMedium,
                                color = DarkGray,
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .clickable {

                                    }
                                    .padding(
                                        vertical = 12.dp,
                                        horizontal = 0.dp
                                    )
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }
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
                Resource.Loading
            )
        }
    }

}